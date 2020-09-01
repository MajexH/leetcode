package main

func main() {

}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	res := new(ListNode)
	rem := res
	add := 0
	for l1 != nil || l2 != nil {
		t1, t2 := 0, 0
		if l1 != nil {
			t1 = l1.Val
		}
		if l2 != nil {
			t2 = l2.Val
		}
		sum := t1 + t2 + add
		add = sum / 10
		res.Next = &ListNode{Val: sum % 10}
		res = res.Next

		if l1 != nil {
			l1 = l1.Next
		}
		if l2 != nil {
			l2 = l2.Next
		}
	}
	if add != 0 {
		res.Next = &ListNode{Val: add}
	}
	return rem.Next
}
