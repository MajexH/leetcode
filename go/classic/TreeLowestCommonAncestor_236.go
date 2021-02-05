package classic

import "container/list"

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	parents := make(map[*TreeNode]*TreeNode)
	// 根节点的父亲为 nil
	parents[root] = nil

	queue := list.New()
	queue.PushBack(root)
	for queue.Len() > 0 && !mapContains(parents, p) || !mapContains(parents, q) {
		head := queue.Remove(queue.Front()).(*TreeNode)
		if head.Left != nil {
			queue.PushBack(head.Left)
			parents[head.Left] = head
		}
		if head.Right != nil {
			queue.PushBack(head.Right)
			parents[head.Right] = head
		}
	}

	// 构建其中一条链
	path := make(map[*TreeNode]*TreeNode)
	for p != nil {
		path[p] = nil
		p = parents[p]
	}

	for !mapContains(path, q) {
		q = parents[q]
	}

	return q
}

func mapContains(memo map[*TreeNode]*TreeNode, node *TreeNode) bool {
	_, ok := memo[node]
	return ok
}
