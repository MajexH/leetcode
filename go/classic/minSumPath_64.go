package classic

import "math"

func minPathSum(grid [][]int) int {
	if grid == nil || len(grid) == 0 {
		return 0
	}
	dp := make([][]int, len(grid))

	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(grid[i]))
	}

	for i := 0; i < len(dp); i++ {
		for j := 0; j < len(dp[i]); j++ {
			left, up := math.MaxInt32, math.MaxInt32
			if i-1 >= 0 {
				left = dp[i-1][j]
			}
			if j-1 >= 0 {
				up = dp[i][j-1]
			}
			m := min(left, up)
			if m == math.MaxInt32 {
				dp[i][j] = grid[i][j]
			} else {
				dp[i][j] = min(left, up) + grid[i][j]
			}

		}
	}

	return dp[len(dp)-1][len(dp[len(dp)-1])-1]
}
