package classic

import "math"

func nthSuperUglyNumber(n int, factors []int) int {
	uglyNums := make([]int, n+1)
	uglyNums[0] = 1
	indexes := make([]int, len(factors))
	for i := 1; i < n; i++ {
		minNumber := math.MaxInt32
		// 找到最小的
		for j := 0; j < len(factors); j++ {
			minNumber = min(minNumber, factors[j]*uglyNums[indexes[j]])
		}
		uglyNums[i] = minNumber
		// 重新定位 indexes位置
		for j := 0; j < len(factors); j++ {
			for factors[j]*uglyNums[indexes[j]] <= minNumber {
				indexes[j]++
			}
		}

	}
	return uglyNums[n-1]
}
