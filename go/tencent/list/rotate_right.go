package main

func main() {
	node := &ListNode{Val: 1}
	node.Next = &ListNode{Val: 2}
	node.Next.Next = &ListNode{Val: 3}
	node.Next.Next.Next = &ListNode{Val: 4}
	node.Next.Next.Next.Next = &ListNode{Val: 5}
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || k == 0 {
		return head
	}
	k = k % length(head)

	preHead := &ListNode{}
	preHead.Next = head
	preLast := preHead

	for k > 0 {
		preLast = preLast.Next
		k--
	}

	for preLast.Next != nil {
		preHead = preHead.Next
		preLast = preLast.Next
	}
	preLast.Next = head
	newHead := preHead.Next
	preHead.Next = nil
	return newHead
}

func length(node *ListNode) int {
	counter := 0
	for node != nil {
		counter++
		node = node.Next
	}
	return counter
}
