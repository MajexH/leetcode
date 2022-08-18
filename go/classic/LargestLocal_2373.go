package classic

func largestLocal(grid [][]int) [][]int {
	res := make([][]int, len(grid)-2)

	for i := 0; i < len(grid)-2; i++ {
		res[i] = make([]int, len(grid)-2)
	}

	for i := 0; i < len(res); i++ {
		for j := 0; j < len(res[i]); j++ {

			tmp := 0
			// 定位中间元素
			for i4g := i; i4g < i+3; i4g++ {
				for j4g := j; j4g < j+3; j4g++ {
					tmp = max(tmp, grid[i4g][j4g])
				}
			}

			res[i][j] = tmp
		}
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
