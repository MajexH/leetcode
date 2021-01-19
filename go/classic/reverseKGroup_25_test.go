package classic

import (
	"testing"
)

func Test_reverseKGroup(t *testing.T) {
	a := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val: 4,
					Next: &ListNode{
						Val:  5,
						Next: nil,
					},
				},
			},
		},
	}

	b := reverseKGroup(a, 3)
	t.Log(b)
}
