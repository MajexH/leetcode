package main

import "fmt"

func jump(nums []int) int {
	dp := make([]int, len(nums))

	for i := 0; i < len(nums); i++ {
		dp[i] = -1
	}

	dp[0] = 0
	for i := 0; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			// dp[j] 不可到达 或者 最远距离无法到达
			if dp[j] == -1 || nums[j]+j < i {
				continue
			}

			if dp[i] == -1 {
				dp[i] = dp[j] + 1
			} else {
				dp[i] = min(dp[i], dp[j]+1)
			}
		}
	}

	return dp[len(nums)-1]
}

func min(i, j int) int {
	if i > j {
		return j
	}
	return i
}

func main() {
	fmt.Println(jump([]int{2, 3, 0, 1, 4}))
}
