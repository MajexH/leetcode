package classic

import "container/list"

func isValid(s string) bool {
	if len(s)%2 != 0 {
		return false
	}
	stack := list.New()
	stack.Init()
	for _, char := range s {
		if char == '(' || char == '{' || char == '[' {
			stack.PushBack(char)
			continue
		}
		if stack.Len() == 0 {
			return false
		}
		top := stack.Remove(stack.Back())

		topChar := top.(int32)
		if (char == ')' && topChar == '(') ||
			(char == '}' && topChar == '{') ||
			(char == ']' && topChar == '[') {
			continue
		}
		return false
	}
	return stack.Len() == 0
}
