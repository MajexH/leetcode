package classic

// findRoot 找到根节点
func findRoot(parents []int, index int) int {
	if parents[index] == -1 {
		return index
	}
	return findRoot(parents, parents[index])
}

// makeConnected 并查集
func makeConnected(n int, connections [][]int) int {
	if len(connections) < n-1 {
		return -1
	}

	// 并查集的 parents 数组，标识 当前索引的 节点的父节点的索引是谁
	// 相同的数最后均能找到同样的父节点
	parents := make([]int, n)
	// 初始化所有的为 -1
	for i := 0; i < n; i++ {
		parents[i] = -1
	}
	res := n
	// 执行 union 的操作
	for _, connection := range connections {
		sRoot := findRoot(parents, connection[0])
		eRoot := findRoot(parents, connection[1])

		// 两个点上有连接线 但是现在还没有连接起来
		// 让其根节点相连
		if sRoot != eRoot {
			// 将 e 节点连接到 s 上
			res--
			parents[eRoot] = sRoot
		}
	}
	return res - 1
}

// makeConnected 方法查看
func makeConnected1(n int, connections [][]int) int {
	// 最短的话肯定是形成一棵树 才能联通所有
	// 所以 边 至少要达到 n - 1 的数量
	// 这个时候不能连通
	if len(connections) < n-1 {
		return -1
	}
	// map 的邻接表表示
	cMap := make(map[int][]int)
	for _, connection := range connections {
		if _, ok := cMap[connection[0]]; !ok {
			cMap[connection[0]] = make([]int, 0)
		}
		cMap[connection[0]] = append(cMap[connection[0]], connection[1])

		if _, ok := cMap[connection[1]]; !ok {
			cMap[connection[1]] = make([]int, 0)
		}
		cMap[connection[1]] = append(cMap[connection[1]], connection[0])
	}

	// 到这里的时候 由于边的数量够 所以一定是可以连通的
	// 这个时候 只需要知道有 m 块是不相连的 然后就知道需要连接的次数就为 m - 1
	memo := make([]bool, n)
	res := 0
	for i := 0; i < n; i++ {
		if !memo[i] {
			res++
			dfs(memo, cMap, i)
		}
	}
	return res - 1
}

func dfs(memo []bool, cMap map[int][]int, start int) {
	memo[start] = true
	for _, next := range cMap[start] {
		if !memo[next] {
			dfs(memo, cMap, next)
		}
	}
}
