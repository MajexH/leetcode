package main

func detectCycle(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}
	last, fast := head, head.Next

	// 确定成环
	for last != fast {
		if fast == nil || fast.Next == nil {
			return nil
		}
		fast = fast.Next.Next
		last = last.Next
	}

	// 找到环的长度
	counter := 1
	fast = fast.Next

	for fast != last {
		counter++
		fast = fast.Next
	}

	// 找到环点
	fast, last = head, head
	for counter > 0 {
		counter--
		fast = fast.Next
	}
	for fast != last {
		fast = fast.Next
		last = last.Next
	}
	return fast
}
