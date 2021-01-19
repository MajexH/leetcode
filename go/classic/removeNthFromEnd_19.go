package classic

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	// 因为可能删除头结点 所有加了一个
	newHead := new(ListNode)
	newHead.Next = head
	// fast 是先走的一个节点 pre 是后走的
	pre, fast := newHead, head
	for n > 0 {
		// 有问题 数量不够
		if fast == nil {
			return nil
		}
		fast = fast.Next
		n--
	}
	// 两个指针开始走
	for fast != nil {
		fast = fast.Next
		pre = pre.Next
	}

	pre.Next = pre.Next.Next
	return newHead.Next
}
