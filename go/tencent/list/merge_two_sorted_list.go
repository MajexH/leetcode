package main

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	res := new(ListNode)

	rem := res

	for l1 != nil && l2 != nil {
		if l1.Val > l2.Val {
			res.Next = l2
			l2 = l2.Next
		} else {
			res.Next = l1
			l1 = l1.Next
		}
		res = res.Next
	}

	if l1 != nil {
		res.Next = l1
	}
	if l2 != nil {
		res.Next = l2
	}

	return rem.Next
}
