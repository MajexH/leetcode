package jzoffer

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	lenA, lenB := getLen(headA), getLen(headB)
	if lenA < lenB {
		return getIntersectionNodeWithLen(headB, headA, lenB, lenA)
	}
	return getIntersectionNodeWithLen(headA, headB, lenA, lenB)
}

func getIntersectionNodeWithLen(headA, headB *ListNode, lenA, lenB int) *ListNode {
	diff := lenA - lenB

	for diff > 0 {
		diff--
		headA = headA.Next
	}

	for headA != headB {
		if headA == nil || headB == nil {
			return nil
		}
		headA = headA.Next
		headB = headB.Next
	}
	return headA
}

func getLen(node *ListNode) int {
	res := 0

	for node != nil {
		res++
		node = node.Next
	}
	return res
}
