package binarySearch

import "testing"

func Test_closestValue(t *testing.T) {
	root := &TreeNode{
		Val:   2147483647,
		Left:  nil,
		Right: nil,
	}

	t.Log(closestValue(root, 0.0))
}
