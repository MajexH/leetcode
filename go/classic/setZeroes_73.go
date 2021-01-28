package classic

func setZeroes(matrix [][]int) {
	xAxis, yAxis := make(map[int]int), make(map[int]int)

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[i]); j++ {
			if matrix[i][j] == 0 {
				xAxis[i] = 0
				yAxis[j] = 0
			}
		}
	}

	for i := range xAxis {
		for j := 0; j < len(matrix[i]); j++ {
			matrix[i][j] = 0
		}
	}

	for j := range yAxis {
		for i := 0; i < len(matrix); i++ {
			matrix[i][j] = 0
		}
	}
}
