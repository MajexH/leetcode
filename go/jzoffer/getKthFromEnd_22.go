package jzoffer

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getKthFromEnd(head *ListNode, k int) *ListNode {
	fast, slow := head, head

	for k > 0 {
		if fast == nil {
			return nil
		}
		fast = fast.Next
		k--
	}

	for fast != nil {
		slow = slow.Next
		fast = fast.Next
	}
	return slow
}
