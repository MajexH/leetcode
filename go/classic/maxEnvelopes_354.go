package classic

import (
	"sort"
)

func maxEnvelopes(envelopes [][]int) int {
	// envelopes[0] 相等 说明宽度相等 这个时候 只需要更长的排在后面即可
	// envelopes[0] 不等 说明宽度不等 这个时候 只需要只需要根据长度大小从大到小排序即可
	sort.Slice(envelopes, func(i, j int) bool {
		if envelopes[i][0] == envelopes[j][0] {
			return envelopes[i][1] > envelopes[j][1]
		} else {
			return envelopes[i][0] < envelopes[j][0]
		}
	})

	// 因为现在这样排序之后 信封的宽度 一定是满足顺序的 那么只需要判断长度 能够形成的最长的递增子序列是多长
	dp := make([]int, len(envelopes))
	// 1 个数字也能有一个长度
	for i := 0; i < len(dp); i++ {
		dp[i] = 1
	}

	res := 0
	for i := 0; i < len(dp); i++ {
		tmp := 0
		for j := 0; j < i; j++ {
			if envelopes[i][1] > envelopes[j][1] {
				tmp = max(tmp, dp[j])
			}
		}
		dp[i] = tmp + 1
		res = max(res, dp[i])
	}

	return res
}
