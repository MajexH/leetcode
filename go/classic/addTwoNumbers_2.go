package classic

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	res := new(ListNode)
	mov := res
	add := 0
	for l1 != nil || l2 != nil {
		var num1, num2 int
		if l1 == nil {
			num1 = 0
		} else {
			num1 = l1.Val
			l1 = l1.Next
		}

		if l2 == nil {
			num2 = 0
		} else {
			num2 = l2.Val
			l2 = l2.Next
		}

		sum := num1 + num2 + add
		mov.Next = &ListNode{
			Val:  sum % 10,
			Next: nil,
		}
		add = sum / 10
		mov = mov.Next
	}
	if add != 0 {
		mov.Next = &ListNode{
			Val: add,
		}
	}
	return res.Next
}
