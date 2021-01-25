package jzoffer

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	res := new(ListNode)
	mov := res
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			mov.Next = l1
			l1 = l1.Next
		} else {
			mov.Next = l2
			l2 = l2.Next
		}
		mov = mov.Next
	}
	if l1 != nil {
		mov.Next = l1
	}
	if l2 != nil {
		mov.Next = l2
	}
	return res.Next
}
