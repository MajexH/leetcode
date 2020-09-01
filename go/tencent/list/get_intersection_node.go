package main

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	l1, l2 := length(headA), length(headB)
	if l2 > l1 {
		return getIntersectionNode(headB, headA)
	}
	diff := l1 - l2

	for diff > 0 {
		diff--
		headA = headA.Next
	}

	for headA != headB {
		headA = headA.Next
		headB = headB.Next
	}
	return headA
}
