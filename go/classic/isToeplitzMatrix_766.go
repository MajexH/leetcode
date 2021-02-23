package classic

func isToeplitzMatrixTravelSlash(matrix [][]int) bool {
	if len(matrix) == 0 {
		return true
	}
	for i := len(matrix) - 1; i >= 0; i-- {
		// 检查斜线
		val := matrix[i][0]

		for m, n := i+1, 1; m < len(matrix) && n < len(matrix[m]); m, n = m+1, n+1 {
			if matrix[m][n] != val {
				return false
			}
		}
	}

	for j := 1; j < len(matrix[0])-1; j++ {
		val := matrix[0][j]

		for m, n := 1, j+1; m < len(matrix) && n < len(matrix[m]); m, n = m+1, n+1 {
			if matrix[m][n] != val {
				return false
			}
		}
	}

	return true
}

func isToeplitzMatrix(matrix [][]int) bool {
	// 每个元素要与自己左上角的相等

	for i := 1; i < len(matrix); i++ {
		for j := 1; j < len(matrix[i]); j++ {
			if matrix[i][j] != matrix[i-1][j-1] {
				return false
			}
		}
	}
	return true
}
