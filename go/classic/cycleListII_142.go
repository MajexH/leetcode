package classic

func detectCycle(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}

	fast, slow := head.Next, head

	for fast != slow {
		if fast == nil || fast.Next == nil {
			return nil
		}
		fast = fast.Next.Next
		slow = slow.Next
	}

	// 一定有环
	count := 0
	fast = fast.Next
	for fast != slow {
		count++
		fast = fast.Next
	}

	// 找到环位置
	fast = head.Next
	slow = head

	for count > 0 {
		fast = fast.Next
		count--
	}

	for fast != slow {
		fast = fast.Next
		slow = slow.Next
	}

	return slow
}
