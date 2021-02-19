package jzoffer

// 和为 s 的连续正整数序列 序列至少包含两个数字
func findContinuousSequence(target int) [][]int {
	res := make([][]int, 0)

	left, right := 1, 2
	sum := left + right
	for right <= (target+1)/2 {
		for sum < target {
			right++
			sum += right
		}

		if sum == target {
			tmp := make([]int, 0)
			for i := left; i <= right; i++ {
				tmp = append(tmp, i)
			}
			res = append(res, tmp)
			right++
			sum += right
		}
		for sum > target {
			sum -= left
			left++
		}
	}
	return res
}
