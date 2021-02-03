package classic

import (
	"testing"
)

func Test_sortList(t *testing.T) {
	a := &ListNode{
		Val: 3,
		Next: &ListNode{
			Val: 6,
			Next: &ListNode{
				Val: 9,
				Next: &ListNode{
					Val:  1,
					Next: nil,
				},
			},
		},
	}
	res := sortList(a)
	t.Log(res)
}
