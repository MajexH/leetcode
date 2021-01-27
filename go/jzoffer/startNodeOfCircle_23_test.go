package jzoffer

import (
	"testing"
)

func Test_findStartNodeOfCirCle(t *testing.T) {
	head := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val: 4,
					Next: &ListNode{
						Val: 5,
						Next: &ListNode{
							Val:  6,
							Next: nil,
						},
					},
				},
			},
		},
	}
	head.Next.Next.Next.Next.Next.Next = head.Next.Next
	t.Log(findStartNodeOfCirCle(head))
}
