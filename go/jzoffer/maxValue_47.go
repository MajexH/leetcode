package jzoffer

func maxValue(grid [][]int) int {
	dp := make([][]int, len(grid))

	for i := 0; i < len(grid); i++ {
		dp[i] = make([]int, len(grid[i]))
	}

	for i := 0; i < len(dp); i++ {
		for j := 0; j < len(dp[i]); j++ {
			if i == 0 && j == 0 {
				dp[i][j] = grid[i][j]
			} else {
				if i == 0 {
					dp[i][j] = dp[i][j-1] + grid[i][j]
				} else if j == 0 {
					dp[i][j] = dp[i-1][j] + grid[i][j]
				} else {
					dp[i][j] = max(dp[i][j-1], dp[i-1][j]) + grid[i][j]
				}
			}
		}
	}

	return dp[len(dp)-1][len(dp[len(dp)-1])-1]
}
