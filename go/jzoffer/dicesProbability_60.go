package jzoffer

import "math"

// n 个筛子扔到地上 问 s 所有的值 可能出现的概率
func dicesProbability(n int) []float64 {
	// 总共会出现几种组合
	total := math.Pow(6.0, float64(n))
	memo := recursionDicesProbability(n)
	res := make([]float64, 6*n+1)
	for key, val := range memo {
		res[key] = float64(val) / total
	}
	return res[n:]
}

func recursionDicesProbability(n int) map[int]int {
	res := make(map[int]int)
	if n <= 0 {
		res[0] = 1
		return res
	}

	afters := recursionDicesProbability(n - 1)
	for i := 1; i <= 6; i++ {
		for key, val := range afters {
			res[key+i] += val
		}
	}

	return res
}
