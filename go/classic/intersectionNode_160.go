package classic

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	lenOfA, lenOfB := countListNodeLength(headA), countListNodeLength(headB)

	if lenOfB > lenOfA {
		return intersectionNode(headB, headA, lenOfB, lenOfA)
	}
	return intersectionNode(headA, headB, lenOfA, lenOfB)
}

func intersectionNode(headA, headB *ListNode, lenOfA, lenOfB int) *ListNode {
	diff := lenOfA - lenOfB
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

func countListNodeLength(node *ListNode) (len int) {
	len = 0
	for node != nil {
		len++
		node = node.Next
	}
	return
}
