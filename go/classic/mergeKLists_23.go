package classic

// mergeKLists 合并k个已经按照升序排列的数组
func mergeKLists(lists []*ListNode) *ListNode {
	return mergeForKLists(lists, 0, len(lists)-1)
}

func mergeForKLists(lists []*ListNode, start, end int) *ListNode {
	if start > end {
		return nil
	}
	if start == end {
		return lists[start]
	}
	mid := (start + end) / 2
	left, right := mergeForKLists(lists, start, mid), mergeForKLists(lists, mid+1, end)
	return mergeTwoList(left, right)
}

func mergeTwoList(list1 *ListNode, list2 *ListNode) *ListNode {
	res := new(ListNode)
	rem := res

	for list1 != nil && list2 != nil {
		if list1.Val > list2.Val {
			res.Next = list2
			list2 = list2.Next
		} else {
			res.Next = list1
			list1 = list1.Next
		}
		res = res.Next
	}
	if list1 != nil {
		res.Next = list1
	}
	if list2 != nil {
		res.Next = list2
	}
	return rem.Next
}
