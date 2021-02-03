package classic

import (
	"testing"
)

func Test_insertionSortList(t *testing.T) {
	a := &ListNode{
		Val: 4,
		Next: &ListNode{
			Val: 3,
			Next: &ListNode{
				Val: 2,
				Next: &ListNode{
					Val: 1,
					Next: &ListNode{
						Val:  0,
						Next: nil,
					},
				},
			},
		},
	}
	res := insertionSortList(a)
	t.Log(res)
}
