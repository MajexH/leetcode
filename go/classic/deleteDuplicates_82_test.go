package classic

import (
	"testing"
)

func Test_deleteDuplicates(t *testing.T) {
	node1 := &ListNode{Val: 1, Next: nil}
	node1.Next = &ListNode{Val: 1, Next: nil}
	node1.Next.Next = &ListNode{Val: 1, Next: nil}
	node1.Next.Next.Next = &ListNode{Val: 2, Next: nil}
	node1.Next.Next.Next.Next = &ListNode{Val: 3, Next: nil}
	//node1.Next.Next.Next.Next.Next = &ListNode{Val: 4, Next: nil}
	//node1.Next.Next.Next.Next.Next.Next = &ListNode{Val: 5, Next: nil}

	res := deleteDuplicates(node1)
	t.Log(res)
}
