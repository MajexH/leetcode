package classic

type node struct {
	X, Y int
}

func (n *node) add(x, y int) {
	n.X += x
	n.Y += y
}

func rotate(matrix [][]int) {
	if matrix == nil || len(matrix) == 0 {
		return
	}
	// 可以用三个数来确定
	x, y, height := 0, len(matrix[0])-1, len(matrix)-1
	// 因为是一个 n * n 的矩阵
	for x < y {
		// 可以确定四个角 然后再通过一个 for 循环去便利四个角
		n1, n2, n3, n4 := &node{x, x}, &node{x, y}, &node{height, y}, &node{height, x}
		for n1.Y < n2.Y {
			matrix[n1.X][n1.Y], matrix[n2.X][n2.Y], matrix[n3.X][n3.Y], matrix[n4.X][n4.Y] =
				matrix[n4.X][n4.Y], matrix[n1.X][n1.Y], matrix[n2.X][n2.Y], matrix[n3.X][n3.Y]
			n1.add(0, 1)
			n2.add(1, 0)
			n3.add(0, -1)
			n4.add(-1, 0)
		}
		x++
		y--
		height--
	}
}
