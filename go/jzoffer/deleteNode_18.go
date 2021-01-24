package jzoffer

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteNode(head *ListNode, val int) *ListNode {
	newHead := new(ListNode)

	newHead.Next = head
	pre, mov := newHead, head
	for mov != nil {
		if mov.Val == val {
			pre.Next = mov.Next
		}
		mov = mov.Next
		pre = pre.Next
	}

	return newHead.Next
}
