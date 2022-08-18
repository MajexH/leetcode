package classic

import (
	"container/list"
	"strconv"
)

func smallestNumber(pattern string) string {
	stack := list.New()

	pattern = pattern + "I"
	res := ""

	for i := 1; i <= len(pattern); i++ {
		if pattern[i-1] == 'I' {
			res += strconv.Itoa(i)
			for stack.Len() > 0 {
				res += strconv.Itoa(stack.Remove(stack.Back()).(int))
			}
		} else {
			stack.PushBack(i)
		}
	}

	return res
}
