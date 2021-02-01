package classic

import "math"

func minCut(s string) int {
	if len(s) == 0 {
		return 0
	}

	dp := make([][]bool, len(s))
	for i := 0; i < len(s); i++ {
		dp[i] = make([]bool, len(s))
	}

	for i := len(s) - 1; i >= 0; i-- {
		for j := i; j < len(s); j++ {
			if s[i] == s[j] {
				dp[i][j] = i == j || i+1 == j || dp[i+1][j-1]
			}
		}
	}

	mins := make([]int, len(s))
	for i := 0; i < len(s); i++ {
		mins[i] = math.MaxInt32
	}

	for i := 0; i < len(s); i++ {
		if dp[0][i] {
			mins[i] = 0
			continue
		}
		// 寻找之间的最小值
		for j := 0; j < i; j++ {
			if dp[j+1][i] {
				mins[i] = min(mins[i], mins[j]+1)
			}
		}
	}
	return mins[len(s)-1]
}
