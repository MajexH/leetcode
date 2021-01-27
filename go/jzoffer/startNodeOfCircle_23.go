package jzoffer

// 循环链表的入口node
func findStartNodeOfCirCle(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}
	// 1. 先判断有环
	fast, slow := head.Next, head
	for fast != slow {
		if fast == nil || fast.Next == nil {
			return nil
		}
		fast = fast.Next.Next
		slow = slow.Next
	}

	// 2. 找到循环的长度
	length := 0
	fast = fast.Next
	for fast != slow {
		fast = fast.Next
		length++
	}

	// 3. 回到头结点 重新走
	slow, fast = head, head.Next
	for length > 0 {
		fast = fast.Next
		length--
	}

	for slow != fast {
		slow = slow.Next
		fast = fast.Next
	}
	return slow
}
