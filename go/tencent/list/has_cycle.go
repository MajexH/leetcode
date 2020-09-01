package main

func hasCycle(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}
	last, fast := head, head.Next

	for last != fast {
		if fast == nil || fast.Next == nil {
			return false
		}
		fast = fast.Next.Next
		last = last.Next
	}
	return true
}
