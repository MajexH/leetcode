package classic

func matrixReshape(nums [][]int, r int, c int) [][]int {
	if len(nums) == 0 || len(nums[0]) == 0 {
		return nums
	}
	// 相当于遍历 根据现在的 index 重新定位

	res := make([][]int, r)
	for i := 0; i < r; i++ {
		res[i] = make([]int, c)
	}

	// 无法转换
	if len(nums)*len(nums[0]) != r*c {
		return nums
	}

	for i := 0; i < len(nums); i++ {
		for j := 0; j < len(nums[i]); j++ {
			index := i*len(nums[i]) + j
			indexI := index / c
			indexJ := index % c
			res[indexI][indexJ] = nums[i][j]
		}
	}

	return res
}
