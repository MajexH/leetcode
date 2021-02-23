package classic

import (
	"math"
)

func splitArray(nums []int, m int) int {

	sum := make([]int, len(nums)+1)
	for i := 1; i <= len(nums); i++ {
		sum[i] += sum[i-1] + nums[i-1]
	}

	// dp[i][j] 表示前 i 个数 分隔 j 段能够形成的和最大值的最小值
	dp := make([][]int, len(nums)+1)
	for i := 0; i <= len(nums); i++ {
		dp[i] = make([]int, m+1)
		for j := 0; j <= m; j++ {
			dp[i][j] = math.MaxInt32
		}
	}
	// 初始化 前 0 个 分隔 0 次 肯定为 0
	dp[0][0] = 0
	// i 当前遍历的右边界
	for i := 1; i <= len(nums); i++ {
		// j 表示的是分隔次数
		for j := 1; j <= min(m, i); j++ {
			// k 表示的是后面的分隔点
			for k := 0; k < i; k++ {
				// 肯定是跟 k 前面的 少一次分隔的 j-1 进行比较 找到分隔的最大值
				dp[i][j] = min(dp[i][j], max(dp[k][j-1], sum[i]-sum[k]))
			}
		}

	}
	return dp[len(nums)][m]
}

// splitArrayWithRecursion 超时了 实际上就是不停地分隔 计算每个子数组的最大值
func splitArrayWithRecursion(nums []int, m int) int {
	sum := make([]int, len(nums)+1)

	for i := 1; i <= len(nums); i++ {
		sum[i] += sum[i-1] + nums[i-1]
	}
	res := math.MaxInt32
	recursionSplitArray(0, len(nums), m, sum, &res, 0)
	return res
}

// n nums 长度
// res 是 结果
// i 当前遍历的 i
func recursionSplitArray(i, n, m int, sum []int, res *int, tmp int) {
	if m == 1 {
		// 剩下的结果
		tmp = max(tmp, sum[n]-sum[i])
		*res = min(*res, tmp)
		return
	}
	// 分隔
	for j := i + 1; j < n; j++ {
		recursionSplitArray(j, n, m-1, sum, res, max(sum[j]-sum[i], tmp))
	}
}
