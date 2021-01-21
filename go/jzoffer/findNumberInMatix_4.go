package jzoffer

func findNumberIn2DArray(matrix [][]int, target int) bool {
	if matrix == nil || len(matrix) == 0 {
		return false
	}
	i, j := 0, len(matrix[0])-1

	for i < len(matrix) && j >= 0 && matrix[i][j] != target {
		if matrix[i][j] < target {
			i++
		} else if matrix[i][j] > target {
			j--
		} else {
			return true
		}
	}

	return i < len(matrix) && j >= 0 && matrix[i][j] == target
}
