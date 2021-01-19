package classic

// reverseKGroup k个一组翻转
func reverseKGroup(head *ListNode, k int) *ListNode {
	newHead := new(ListNode)
	newHead.Next = head

	var preStartNode, endNode *ListNode = newHead, nil
	counter := 0
	mov := newHead

	for mov != nil {
		if counter == k {
			endNode = mov
			afterEnd := endNode.Next
			reverseHead, reverseEnd := reverseBetweenNodes(preStartNode.Next, endNode.Next)
			preStartNode.Next = reverseHead
			reverseEnd.Next = afterEnd

			counter = 0
			preStartNode = reverseEnd
			// 重新定位移标
			mov = reverseEnd
		}
		mov = mov.Next
		counter++
	}

	return newHead.Next
}
