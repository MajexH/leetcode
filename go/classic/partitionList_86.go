package classic

// partitionList 要求的是所有小于x的节点都在 大于它的节点之前
func partitionList(head *ListNode, x int) *ListNode {
	array1, array2 := make([]*ListNode, 0), make([]*ListNode, 0)

	for tmp := head; tmp != nil; tmp = tmp.Next {
		if tmp.Val < x {
			array1 = append(array1, tmp)
		} else {
			array2 = append(array2, tmp)
		}
	}

	res := new(ListNode)
	mv := res

	for _, tmp := range array1 {
		mv.Next = tmp
		mv = mv.Next
	}

	for _, tmp := range array2 {
		mv.Next = tmp
		mv = mv.Next
	}
	mv.Next = nil

	return res.Next
}
