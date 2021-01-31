package classic

func union(parents []int, i, j int) {
	iRoot, jRoot := findRootOfParents(parents, i), findRootOfParents(parents, j)
	if iRoot != jRoot {
		parents[jRoot] = iRoot
	}
}

func findRootOfParents(parents []int, i int) int {
	if parents[i] == i {
		return i
	}
	return findRootOfParents(parents, parents[i])
}

func isConnectedParents(parents []int, i, j int) bool {
	return findRootOfParents(parents, i) == findRootOfParents(parents, j)
}

var (
	// 表示上下左右四个方向
	DIRECTIONS = [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}
)

func swimInWater(grid [][]int) int {
	if grid == nil {
		return -1
	}
	n := len(grid)

	index := make([]int, n*n)

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			// 因为题目中所述，grid 里面的数值从 0 -> n * n - 1
			// 所以让高度作为下标索引 方便下面遍历
			index[grid[i][j]] = n*i + j
		}
	}
	// grid 的二位数组 可以转为 n * i + j 的一维坐标
	parents := make([]int, n*n)
	for i := 0; i < n*n; i++ {
		parents[i] = i
	}

	for i := 0; i < n*n; i++ {
		x, y := index[i]/n, index[i]%n
		for _, direction := range DIRECTIONS {
			newX, newY := x+direction[0], y+direction[1]
			// 因为这个是从高度相距只有1的地方开始的 所以可以直接关联
			// 这样当 0 n - 1 连接到一起的时候 说明已经达到的最小的高度
			// 只有新的节点的高度 小于 当前的高度 才是可以游过去的！！！
			if !(newX < 0 || newX >= n || newY < 0 || newY >= n) && grid[newX][newY] <= i {
				// index 的索引用在这个地方
				union(parents, index[i], newX*n+newY)
			}

			if isConnectedParents(parents, 0, n*n-1) {
				return i
			}
		}
	}
	return -1
}
