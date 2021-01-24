package jzoffer

import "math"

func printNumbers(n int) []int {
	max := math.Pow(10, float64(n))

	res := make([]int, int(max-1))

	for i := 1; float64(i) < max; i++ {
		res[i-1] = i
	}

	return res
}
