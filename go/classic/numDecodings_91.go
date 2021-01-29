package classic

import "strconv"

func numDecodings(s string) int {
	if len(s) == 0 {
		return 0
	}
	// dp[i] 表示 s[0:i] 不包括i能生成的数量
	// dp[i] = dp[i-1]+dp[i-2]
	dp := make([]int, len(s)+1)
	dp[0] = 1
	for i := 1; i <= len(s); i++ {
		for j := max(i-2, 0); j < i; j++ {
			if canDecoding(s[j:i]) {
				dp[i] += dp[j]
			}
		}
	}
	return dp[len(s)]
}

func canDecoding(s string) bool {
	if len(s) > 1 && s[0] == '0' {
		return false
	}

	if num, err := strconv.Atoi(s); err != nil || num > 26 || num < 1 {
		return false
	}
	return true
}
