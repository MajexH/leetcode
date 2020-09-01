package main

import (
	"container/list"
	"fmt"
)

func main() {
	fmt.Println(generateParenthesis(3))
}

func generateParenthesis(n int) []string {
	res := list.New()
	recursion(res, "", n, n)
	returnVal := make([]string, res.Len())
	for e, i := res.Front(), 0; e != nil; e, i = e.Next(), i+1 {
		returnVal[i] = (e.Value).(string)
	}
	return returnVal
}

func recursion(res *list.List, temp string, left, right int) {
	if left == 0 && right == 0 {
		res.PushBack(temp)
		return
	}
	if left > 0 {
		recursion(res, temp+"(", left-1, right)
	}
	if right > 0 && right > left {
		recursion(res, temp+")", left, right-1)
	}
}
