package classic

// insertionSortList 链表的插入排序
func insertionSortList(head *ListNode) *ListNode {
	newHead := new(ListNode)
	newHead.Next = head
	pre := newHead
	for i := head; i != nil; {
		tmp := i.Next
		for j := newHead; j != i; j = j.Next {
			// 找到插入的点 这个时候把这个 i 这个位置插入到 j 这个位置之前
			if j.Next.Val > i.Val {
				// 因为这个里面是直接交换的 node 的位置
				// 导致外部循环多循环了几次 因此超时
				pre.Next = i.Next
				i.Next = j.Next
				j.Next = i
				// 交换之后要重新定位

				break
			}
		}
		// 重新定位
		pre = newHead
		for pre.Next != tmp {
			pre = pre.Next
		}
		i = tmp
	}
	return newHead.Next
}
