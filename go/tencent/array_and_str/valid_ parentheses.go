package main

import (
	"container/list"
	"fmt"
)

func main() {
	fmt.Println(isValid("())"))
}

func isValid(s string) bool {
	stack := list.New()
	for _, char := range s {
		if char == '(' || char == '{' || char == '[' {
			stack.PushBack(char)
		} else {
			// 弹出
			if stack.Len() == 0 {
				return false
			} else {
				if char == ')' && stack.Back().Value == '(' {
					stack.Remove(stack.Back())
					continue
				}
				if char == ']' && stack.Back().Value == '[' {
					stack.Remove(stack.Back())
					continue
				}
				if char == '}' && stack.Back().Value == '{' {
					stack.Remove(stack.Back())
					continue
				}
				return false
			}

		}
	}
	return stack.Len() == 0
}
