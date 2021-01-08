package main

import "container/list"

func lowestCommonAncestorII(root, p, q *TreeNode) *TreeNode {
	queue, memo := list.New(), make(map[*TreeNode]*TreeNode)

	memo[root] = nil
	queue.PushBack(root)

	for queue.Len() > 0 && (!contain(memo, p) || !contain(memo, q)) {
		top := queue.Remove(queue.Front()).(*TreeNode)

		if top.Left != nil {
			queue.PushBack(top.Left)
			memo[top.Left] = top
		}

		if top.Right != nil {
			queue.PushBack(top.Right)
			memo[top.Right] = top
		}

	}

	parents := make(map[*TreeNode]interface{})
	for p != nil {
		parents[p] = nil
		p = memo[p]
	}

	for !contain1(parents, q) {
		q = memo[q]
	}
	return q
}

func contain(memo map[*TreeNode]*TreeNode, node *TreeNode) bool {
	_, ok := memo[node]
	return ok
}

func contain1(memo map[*TreeNode]interface{}, node *TreeNode) bool {
	_, ok := memo[node]
	return ok
}
