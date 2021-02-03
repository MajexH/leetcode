package classic

func sortList(head *ListNode) *ListNode {
	return mergeSort(head)
}

func mergeSort(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	mid := divideList(head)
	return mergeTwoListNode(mergeSort(head), mergeSort(mid))
}

func mergeTwoListNode(left, right *ListNode) *ListNode {
	res := new(ListNode)
	mov := res

	for left != nil && right != nil {
		if left.Val > right.Val {
			mov.Next = right
			right = right.Next
		} else {
			mov.Next = left
			left = left.Next
		}
		mov = mov.Next
	}

	if left != nil {
		mov.Next = left
	}
	if right != nil {
		mov.Next = right
	}
	return res.Next
}

// divideList 会把 list 分为两个 list
// 会截断原来的 node
func divideList(node *ListNode) *ListNode {
	if node == nil || node.Next == nil {
		return node
	}
	fast := node.Next

	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		node = node.Next
	}
	mid := node.Next
	node.Next = nil
	return mid
}
