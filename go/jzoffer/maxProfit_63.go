package jzoffer

import "math"

func maxProfit(prices []int) int {
	preMin := math.MaxInt32

	res := 0

	for _, price := range prices {
		if price < preMin {
			preMin = price
		}
		if res < price-preMin {
			res = price - preMin
		}
	}

	return res
}
