package classic

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	dp := make([][]int, len(obstacleGrid))

	for i := 0; i < len(obstacleGrid); i++ {
		dp[i] = make([]int, len(obstacleGrid[i]))
	}
	dp[0][0] = 1
	for i := 0; i < len(obstacleGrid); i++ {
		for j := 0; j < len(obstacleGrid[0]); j++ {
			if obstacleGrid[i][j] == 1 {
				dp[i][j] = 0
				continue
			}
			if i-1 >= 0 {
				dp[i][j] += dp[i-1][j]
			}
			if j-1 >= 0 {
				dp[i][j] += dp[i][j-1]
			}
		}
	}

	return dp[len(obstacleGrid)-1][len(obstacleGrid[len(obstacleGrid)-1])-1]
}
