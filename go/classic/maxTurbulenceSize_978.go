package classic

// maxTurbulenceSize
func maxTurbulenceSize(arr []int) int {
	// 仍然是一升一降 才能使符号反号

	up, down := 1, 1
	res := 1
	for i := 1; i < len(arr); i++ {
		if arr[i] > arr[i-1] {
			up = down + 1
			down = 1
		} else if arr[i] < arr[i-1] {
			down = up + 1
			up = 1
		} else {
			up, down = 1, 1
		}
		res = max(res, max(up, down))
	}

	return res
}

// maxTurbulenceSizeWithDP 看起来像个 dp 问题
// 因为 如果 i -> j 是均流数组 那么只需要判断 前后各加一个是否是 即可
// dp 超时了 !!
func maxTurbulenceSizeWithDP(arr []int) int {
	dp := make([][]bool, len(arr))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]bool, len(arr))
	}
	res := 0
	for i := len(arr) - 1; i >= 0; i-- {
		for j := i; j < len(arr); j++ {
			// 这儿只有以下几种情况
			// 1. i == j 一个数的情况 肯定是的
			// 2. i + 1 == j 也是可以的 但是这个就已经确定了方向了
			// 3. dp[i][j-1] 这个时候只需要判断跟最后一个数的大小与方向是否吻合即可
			if i == j || (i+1 == j && arr[i] != arr[j]) {
				dp[i][j] = true
			} else {
				// 这个时候相当于加上了一个 j 的数字 能否再形成 均流
				if dp[i][j-1] &&
					(((j-i)%2 == 1 && ((arr[i] > arr[i+1] && arr[j] < arr[j-1]) || (arr[i] < arr[i+1] && arr[j] > arr[j-1]))) ||
						((j-i)%2 == 0 && ((arr[i] > arr[i+1] && arr[j] > arr[j-1]) || (arr[i] < arr[i+1] && arr[j] < arr[j-1])))) {
					dp[i][j] = true
				}
			}
			if dp[i][j] {
				res = max(res, j-i+1)
			}
		}
	}
	return res
}
