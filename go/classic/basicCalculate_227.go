package classic

import "container/list"

// a < b 返回 false
func cmpOperatorPriority(a, b byte) bool {
	if (a == '+' || a == '-') && (b == '*' || b == '/') {
		return false
	}
	return (b == '+' || b == '-') && (a == '*' || a == '/')
}

func operate(a, b int, char byte) int {
	switch char {
	case '+':
		return a + b
	case '-':
		return b - a
	case '*':
		return a * b
	default:
		return b / a
	}
}

// 实现中缀表达式的计算
func calculate(s string) int {

	operator := list.New()
	nums := list.New()

	for i := 0; i < len(s); {
		if s[i] == ' ' {
			i++
			continue
		}
		if s[i] >= '0' && s[i] <= '9' {
			// 多个组成一个字符串
			sum := 0
			for i < len(s) && s[i] >= '0' && s[i] <= '9' {
				sum = sum*10 + int(s[i]-'0')
				i++
			}
			nums.PushBack(sum)
		} else {
			if operator.Len() == 0 {
				operator.PushBack(s[i])
			} else {
				// 如果后进来的优先级大
				for operator.Len() > 0 && !cmpOperatorPriority(s[i], operator.Back().Value.(byte)) {
					nums.PushBack(operate(nums.Remove(nums.Back()).(int), nums.Remove(nums.Back()).(int), operator.Remove(operator.Back()).(byte)))
				}
				operator.PushBack(s[i])
			}
			i++
		}
	}

	for operator.Len() > 0 {
		nums.PushBack(operate(nums.Remove(nums.Back()).(int), nums.Remove(nums.Back()).(int), operator.Remove(operator.Back()).(byte)))
	}
	return nums.Remove(nums.Back()).(int)
}
