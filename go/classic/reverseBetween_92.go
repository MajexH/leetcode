package classic

func reverseBetween(head *ListNode, m int, n int) *ListNode {
	newHead := new(ListNode)
	newHead.Next = head
	cp := newHead
	var preStartNode, endNode *ListNode = nil, nil
	for i := 0; cp != nil; cp, i = cp.Next, i+1 {
		if i == m-1 {
			preStartNode = cp
		}
		if i == n {
			endNode = cp
		}
	}
	afterEndNode := endNode.Next
	reverseHead, reverseEnd := reverseBetweenNodes(preStartNode.Next, endNode.Next)
	preStartNode.Next = reverseHead
	reverseEnd.Next = afterEndNode

	return newHead.Next
}

// reverseBetweenNodes reverse两个node之间的链表
// 其中 startNode 为开始翻转的节点 endNodeNext 为结束翻转的节点的后一个节点
func reverseBetweenNodes(startNode, endNodeNext *ListNode) (*ListNode, *ListNode) {
	var newHead *ListNode = nil
	newEndNode := startNode
	for startNode != endNodeNext {
		next := startNode.Next
		startNode.Next = newHead
		newHead = startNode
		startNode = next
	}
	return newHead, newEndNode
}
