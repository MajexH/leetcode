package jzoffer

import "strconv"

// translateNum 翻译 num 成字符串 有几种方法
// 0 - a 1 - b ………… 25 - z
func translateNum(num int) int {
	str := strconv.Itoa(num)
	// dp[i] 表示 可以翻译成几种
	dp := make([]int, len(str)+1)
	dp[len(str)] = 1
	for i := len(str) - 1; i >= 0; i-- {
		for j := i + 1; j <= min(i+2, len(str)); j++ {
			if canTranslate(str[i:j]) {
				dp[i] += dp[j]
			}
		}
	}
	return dp[0]
}

func canTranslate(str string) bool {
	if len(str) > 1 && str[0] == '0' {
		return false
	}
	i, _ := strconv.Atoi(str)
	return i >= 0 && i <= 25
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
