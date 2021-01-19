package classic

import (
	"testing"
)

func Test_reverseBetween(t *testing.T) {
	test := &ListNode{
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

	t.Log(reverseBetween(test, 2, 4))
}
