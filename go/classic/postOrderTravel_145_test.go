package classic

import (
	"testing"
)

func Test_postorderTraversal(t *testing.T) {
	node := &TreeNode{
		Val:  1,
		Left: nil,
		Right: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val:   3,
				Left:  nil,
				Right: nil,
			},
			Right: nil,
		},
	}
	t.Log(postorderTraversal(node))
}
