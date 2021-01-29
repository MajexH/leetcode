package classic

func deleteDuplicates(head *ListNode) *ListNode {
	newHead := new(ListNode)
	newHead.Next = head

	pre, last := newHead, head

	for last != nil {
		for last != nil && last.Val == pre.Next.Val {
			last = last.Next
		}

		// 说明有重复
		if pre.Next.Next != last {
			pre.Next = last
		} else {
			// 没有重复
			pre = pre.Next
			if last != nil {
				last = last.Next
			}
		}

	}

	return newHead.Next
}
