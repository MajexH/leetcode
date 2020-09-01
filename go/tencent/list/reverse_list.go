package main

import "fmt"

func main() {
	res := new(ListNode)
	res.Val = 1
	res.Next = new(ListNode)
	res.Next.Val = 2
	res.Next.Next = new(ListNode)
	res.Next.Next.Val = 3
	res = reverseList(res)
	fmt.Println()
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	var res *ListNode = nil
	for head != nil {
		next := head.Next
		head.Next = res
		res = head
		head = next
	}
	return res
}
