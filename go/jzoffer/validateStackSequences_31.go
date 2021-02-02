package jzoffer

import "container/list"

func validateStackSequences(pushed []int, popped []int) bool {
	stack := list.New()

	for i, j := 0, 0; i < len(pushed); i++ {
		if pushed[i] != popped[j] {
			stack.PushBack(pushed[i])
			continue
		}
		// 弹出
		j++
		// 直到 popped 和已经加入栈的不同
		for j < len(popped) && stack.Len() > 0 && stack.Back().Value.(int) == popped[j] {
			stack.Remove(stack.Back())
			j++
		}
	}

	return stack.Len() == 0
}
