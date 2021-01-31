package classic

import "math"

func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return -1
	}

	res := 0

	preMin := math.MaxInt32

	for _, price := range prices {
		if preMin > price {
			preMin = price
		}
		res = max(res, price-preMin)
	}
	return res
}
