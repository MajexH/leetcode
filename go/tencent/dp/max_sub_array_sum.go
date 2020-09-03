package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(maxSubArray([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
}

func maxSubArray(nums []int) int {
	dp := make([]int, len(nums)+1)
	res := math.MinInt64
	for i := 1; i <= len(nums); i++ {
		if dp[i-1] < 0 {
			dp[i] = nums[i-1]
		} else {
			dp[i] = nums[i-1] + dp[i-1]
		}
		if res < dp[i] {
			res = dp[i]
		}
	}

	return res
}
