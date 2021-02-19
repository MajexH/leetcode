package classic

import "math"

func maxSumAfterPartitioning(arr []int, k int) int {
	dp := make([]int, len(arr))

	for i := 0; i < len(arr); i++ {
		tmpMax := math.MinInt32
		// 第二个循环必须从后向前 因为从前向后的时候 找到 tmpMax 不一定是 整个的最大值
		// 因为 j 相当于是 j 之后的数字都要变成这个最大值
		for j := i; j >= max(0, i-k+1); j-- {
			tmpMax = max(tmpMax, arr[j])
			if j >= 1 {
				dp[i] = max(dp[i], dp[j-1]+tmpMax*(i-j+1))
			} else {
				dp[i] = max(dp[i], tmpMax*(i-j+1))
			}
		}
	}

	return dp[len(dp)-1]
}
