package classic

func numDistinct(s string, t string) int {
	// dp[i][j] 表示 s[i-1] 和 t[j-1] 之间有多少组合
	dp := make([][]int, len(s)+1)
	for i := 0; i <= len(s); i++ {
		dp[i] = make([]int, len(t)+1)
	}

	// 初始化 只要 t 是空 那么一定可以 在 s 中找到
	for i := 0; i <= len(s); i++ {
		dp[i][0] = 1
	}

	for i := 1; i <= len(s); i++ {
		for j := 1; j <= len(t); j++ {
			if s[i-1] == t[j-1] {
				// 分为两个部分 因为可以不算当前的 s 串的最后一个 也可以算上
				// 因为 s 串的前面部分 可能已经匹配到了
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}

	return dp[len(s)][len(t)]
}
