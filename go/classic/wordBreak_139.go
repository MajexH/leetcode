package classic

// wordBreak 尝试不采用递归 使用 dp
func wordBreak(s string, wordDict []string) bool {
	set := make(map[string]int)

	for _, word := range wordDict {
		set[word] = 1
	}

	// dp[i] 表示 0 -i 这个字符串能否分隔
	dp := make([]bool, len(s)+1)
	// 长度为 0 的 "" 空串肯定可以
	dp[0] = true

	for i := 1; i <= len(s); i++ {
		for j := 0; j < i; j++ {
			if _, ok := set[s[j:i]]; ok && dp[j] {
				dp[i] = true
				break
			}
		}
	}

	return dp[len(s)]
}

// wordBreakWithRecursion 超时 因为可能存在 aaaaaaa 等一系列重复分隔的字符串
func wordBreakWithRecursion(s string, wordDict []string) bool {
	set := make(map[string]int)

	for _, word := range wordDict {
		set[word] = 1
	}

	return recursionWordBreak(0, s, set)
}

func recursionWordBreak(start int, s string, set map[string]int) bool {
	if start > len(s) {
		return false
	}
	if start == len(s) {
		return true
	}

	for j := start + 1; j <= len(s); j++ {
		if _, ok := set[s[start:j]]; ok {
			if recursionWordBreak(j, s, set) {
				return true
			}
		}
	}
	return false
}
