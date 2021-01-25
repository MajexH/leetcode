package classic

// regionsBySlashes 通过斜杠划分
func regionsBySlashes(grid []string) int {
	// n * n 的矩阵的长度
	length := len(grid)
	// 为了使用 并查集 将一个1*1 的正方形，即 一个 grid[i] 标识的区域分成 四个地方
	// 然后再根据 / \\ 两个符号的位置进行合并 最后看有几个节点
	unionSize := 4 * length * length
	u := NewUnionFind(unionSize)

	for i, str := range grid {
		for j, char := range str {
			// 0 号位置
			uIndex := 4 * (i*length + j)

			// 同一个单元格里面的连接起来
			switch char {
			// 0 1 2 3 都要连接起来
			case ' ':
				u.union(uIndex, uIndex+1)
				u.union(uIndex+1, uIndex+2)
				u.union(uIndex+2, uIndex+3)
			case '\\':
				// 反斜杠的话 01 23 分别连接
				u.union(uIndex, uIndex+1)
				u.union(uIndex+2, uIndex+3)
			case '/':
				// 斜杠的话 03 12 分贝连接
				u.union(uIndex, uIndex+3)
				u.union(uIndex+1, uIndex+2)
			}
			// 单元格外面的连接起来
			// 不管是 \\ 还是 / 这个区域的1一定可以和右边下一个区域( j+ 1)的 3 连接
			// 这个区域的 2 一定可以和下边(i + 1)下一个区域的 0 连接
			if j+1 < length {
				u.union(uIndex+1, 4*(i*length+j+1)+3)
			}
			if i+1 < length {
				u.union(uIndex+2, 4*((i+1)*length+j))
			}
		}
	}

	return u.GetCount()
}

type unionFind struct {
	Parents []int
	Count   int // 表示连通分量的多少
}

func NewUnionFind(size int) *unionFind {
	res := &unionFind{
		Parents: make([]int, size),
		Count:   size,
	}
	// 初始化并查集中的每个元素的父节点都是自己
	for i := 0; i < size; i++ {
		res.Parents[i] = i
	}
	return res
}

func (u *unionFind) union(i, j int) {
	iRoot := u.find(i)
	jRoot := u.find(j)
	if iRoot != jRoot {
		u.Parents[jRoot] = iRoot
		// 每次连接一个之后 最大连通分量就要 --
		u.Count--
	}
}

func (u *unionFind) find(i int) int {
	if u.Parents[i] == i {
		return i
	}
	return u.find(u.Parents[i])
}

func (u *unionFind) GetCount() int {
	return u.Count
}
