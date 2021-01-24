package classic

import "math"

func findLengthOfLCIS(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	curLength, pre := 0, math.MinInt32
	res := 0
	for _, num := range nums {
		if num > pre {
			curLength++
		} else {
			curLength = 1
		}
		pre = num
		res = max(res, curLength)
	}

	return res
}
