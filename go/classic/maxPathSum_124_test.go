package classic

import "testing"

func Test_maxPathSum(t *testing.T) {
	node := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val:   2,
			Left:  nil,
			Right: nil,
		},
		Right: &TreeNode{
			Val:   3,
			Left:  nil,
			Right: nil,
		},
	}
	t.Log(maxPathSum(node))
}
