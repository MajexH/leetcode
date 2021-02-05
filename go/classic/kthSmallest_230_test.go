package classic

import "testing"

func Test_kthSmallest(t *testing.T) {
	a := &TreeNode{
		Val: 2,
		Left: &TreeNode{
			Val:   1,
			Left:  nil,
			Right: nil,
		},
		Right: nil,
	}
	t.Log(kthSmallest(a, 1))
}
