package jzoffer

import "container/list"

func kthLargest(root *TreeNode, k int) int {
	if root == nil {
		return -1
	}
	return recursionKthLargest(root, k).Val
}

func countTreeNumber(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return countTreeNumber(root.Left) + countTreeNumber(root.Right) + 1
}

func recursionKthLargest(root *TreeNode, k int) *TreeNode {
	if root == nil {
		return nil
	}
	rightNodeNumber := countTreeNumber(root.Right) + 1

	if rightNodeNumber > k {
		// 在右边寻找
		return recursionKthLargest(root.Right, k)
	} else if rightNodeNumber < k {
		return recursionKthLargest(root.Left, k-rightNodeNumber)
	} else {
		return root
	}
}

// 使用两个 queue 在遍历 root 的同时 维护一个窗口
func kthLargestWithTwoQueue(root *TreeNode, k int) int {
	if root == nil {
		return -1
	}
	queue := list.New()
	var window []*TreeNode
	for queue.Len() > 0 || root != nil {
		for root != nil {
			queue.PushBack(root)
			root = root.Left
		}
		if queue.Len() > 0 {
			root = queue.Remove(queue.Back()).(*TreeNode)
			window = append(window, root)
			if len(window) > k {
				window = window[1:]
			}
			root = root.Right
		}
	}

	return window[0].Val
}
