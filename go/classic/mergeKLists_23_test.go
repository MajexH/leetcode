package classic

import (
	"testing"
)

func Test_mergeKLists(t *testing.T) {
	a, b, c := new(ListNode), new(ListNode), new(ListNode)
	a = &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 4,
			Next: &ListNode{
				Val:  5,
				Next: nil,
			},
		},
	}
	b = &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 3,
			Next: &ListNode{
				Val:  4,
				Next: nil,
			},
		},
	}
	c = &ListNode{
		Val: 2,
		Next: &ListNode{
			Val:  6,
			Next: nil,
		},
	}
	lists := []*ListNode{a, b, c}
	res := mergeKLists(lists)
	t.Log(res)
}
