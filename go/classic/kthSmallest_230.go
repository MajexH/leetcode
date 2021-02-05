package classic

import "container/list"

func kthSmallest(root *TreeNode, k int) int {
	return recursionKthSmallest(root, k).Val
}

func recursionKthSmallest(root *TreeNode, k int) *TreeNode {
	if root == nil {
		return nil
	}
	left := countTree(root.Left)
	if left+1 > k {
		return recursionKthSmallest(root.Left, k)
	} else if left+1 < k {
		return recursionKthSmallest(root.Right, k-left-1)
	} else {
		return root
	}
}

func countTree(node *TreeNode) int {
	if node == nil {
		return 0
	}
	return countTree(node.Left) + countTree(node.Right) + 1
}

// BST 的 第 k 小
func kthSmallestWithStack(root *TreeNode, k int) int {
	stack := list.New()
	counter := 0
	for root != nil || stack.Len() > 0 {
		for root != nil {
			stack.PushBack(root)
			root = root.Left
		}
		if stack.Len() > 0 {
			root = stack.Remove(stack.Back()).(*TreeNode)
			if counter == k-1 {
				return root.Val
			}
			counter++
			root = root.Right
		}
	}
	return -1
}
