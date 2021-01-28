package classic

func generateMatrix(n int) [][]int {
	res := make([][]int, n)
	for i := 0; i < n; i++ {
		res[i] = make([]int, n)
	}
	x, y, h := 0, n-1, n-1
	i := 1
	for x < y {
		for j := x; j < y; j++ {
			res[x][j] = i
			i++
		}

		for j := x; j < h; j++ {
			res[j][y] = i
			i++
		}

		for j := y; j > x; j-- {
			res[h][j] = i
			i++
		}

		for j := h; j > x; j-- {
			res[j][x] = i
			i++
		}

		x++
		y--
		h--
	}
	if x == y {
		res[x][y] = i
	}
	return res
}
