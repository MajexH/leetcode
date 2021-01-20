package classic

import "container/list"

// dp[i] 表示 s[i] 的最长匹配的括号长度是多少
// 而只有右括号会考虑匹配问题，
// 所以 s[i-1] 为 ( 时，相当于在 dp[i - 1] 的基础上有加了一对括号
// s[i - 1] 为 ) 时，需要考虑 dp[i - 1] 的长度之前的符号是否为 ( 为 ( 说明需要加上这一对括号
func longestValidParentheses1(s string) int {
	dp := make([]int, len(s), len(s))
	for i := 0; i < len(s); i++ {
		dp[i] = 0
	}
	res := 0
	for i := 1; i < len(s); i++ {
		if s[i] == ')' {
			if s[i-1] == '(' {
				if i-2 >= 0 {
					dp[i] = dp[i-2] + 2
				} else {
					dp[i] = 2
				}
			} else if s[i-1] == ')' {
				if i-dp[i-1]-1 >= 0 && s[i-dp[i-1]-1] == '(' {
					if i-dp[i-1]-2 >= 0 {
						// 同时因为可能和之前的组成亦可以合理的 括号集合 所以还要加上匹配的 ( 之前的匹配的长度
						dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
					} else {
						dp[i] = dp[i-1] + 2
					}

				}
			}
		}
		res = max(res, dp[i])
	}

	return res
}

// 这个使用栈来做
func longestValidParentheses(s string) int {
	stack := list.New()
	stack.PushBack(-1)
	res := 0
	for i, char := range s {
		switch char {
		case '(':
			stack.PushBack(i)
		case ')':
			// 移除掉匹配的 (
			stack.Remove(stack.Back())
			if stack.Len() == 0 {
				// 如果这个时候栈为空 说明吧最开始的 -1 或者一个 右括号也弹出了 这个时候把
				// 现在右括号的地址放上去即可
				stack.PushBack(i)
			} else {
				// 因为弹出了匹配的括号 所有在之前加入的 括号就是上一个不匹配的地方 减去得到其最大长度
				res = max(res, i-stack.Back().Value.(int))
			}
		}
	}
	return res
}
