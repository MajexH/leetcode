package main

import "fmt"

func main() {
	fmt.Println(maxProfitII([]int{1, 2, 3, 4, 5}))
}

func maxProfitII(prices []int) int {
	res := 0
	if prices == nil || len(prices) < 2 {
		return res
	}
	peak, valley := prices[0], prices[0]

	for i := 0; i < len(prices)-1; {
		// 找到 valley
		for i < len(prices)-1 && prices[i] >= prices[i+1] {
			i++
		}
		valley = prices[i]
		// 找到 peak
		for i < len(prices)-1 && prices[i] <= prices[i+1] {
			i++
		}
		peak = prices[i]
		res += peak - valley
	}

	return res
}
