package classic

func reverseList(head *ListNode) *ListNode {
	var pre *ListNode = nil

	for head != nil {
		next := head.Next
		head.Next = pre
		pre = head
		head = next
	}
	return pre
}
