package main

import "math"

func maxProfit(prices []int) int {
	if prices == nil || len(prices) < 2 {
		return 0
	}

	min, res := math.MaxInt64, math.MinInt64

	for _, val := range prices {
		if min > val {
			min = val
		}
		if temp := val - min; temp > res {
			res = temp
		}
	}

	return res
}
