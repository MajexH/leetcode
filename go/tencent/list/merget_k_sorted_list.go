package main

func mergeKLists(lists []*ListNode) *ListNode {
	return mergeSort(lists, 0, len(lists)-1)
}

func mergeSort(lists []*ListNode, start, end int) *ListNode {
	if start > end {
		return nil
	}
	if start == end {
		return lists[start]
	}
	mid := (start + end) / 2

	left, right := mergeSort(lists, start, mid), mergeSort(lists, mid+1, end)
	return mergeTwoLists(left, right)
}
