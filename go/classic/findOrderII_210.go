package classic

// 找到它的拓扑排序
func findOrder(numCourses int, prerequisites [][]int) []int {
	// 成环的是不能形成拓扑排序的
	// 进行成环检测
	mapOfCourses := make([][]int, numCourses)

	for i := 0; i < numCourses; i++ {
		mapOfCourses[i] = make([]int, 0)
	}
	// 构建有向图
	for _, prerequisite := range prerequisites {
		mapOfCourses[prerequisite[1]] = append(mapOfCourses[prerequisite[1]], prerequisite[0])
	}
	// 判断成环
	if isMapCircle(mapOfCourses, numCourses) {
		return []int{}
	}
	// 然后再不停的删除 出度为 0 的点
	return findTopologyOrder(mapOfCourses, numCourses, prerequisites)
}

func isMapCircle(mapOfCourses [][]int, numCourses int) bool {
	totalMemo := make([]bool, numCourses)
	for i := 0; i < numCourses; i++ {
		if dfsIsMapCircle(i, mapOfCourses, make([]bool, numCourses), totalMemo) {
			return true
		}
	}
	return false
}

func dfsIsMapCircle(start int, mapOfCourses [][]int, memo []bool, totalMemo []bool) bool {
	if totalMemo[start] {
		return false
	}
	totalMemo[start] = true
	memo[start] = true
	for _, node := range mapOfCourses[start] {
		if memo[node] {
			// 重新访问了 肯定是有成环的
			return true
		}
		isCircle := dfsIsMapCircle(node, mapOfCourses, memo, totalMemo)
		if isCircle {
			return true
		}
	}
	memo[start] = false
	return false
}

func findTopologyOrder(mapOfCourses [][]int, numCourses int, prerequisites [][]int) []int {
	res := make([]int, 0)
	// 构建入度为 0 的点 然后不停的遍历出度为 0 的点
	inDegreeCounter := make([]int, numCourses)
	for _, prerequisite := range prerequisites {
		inDegreeCounter[prerequisite[0]]++
	}

	inDegreeEqualsZero := make([]int, 0)

	for i, inDegree := range inDegreeCounter {
		if inDegree == 0 {
			inDegreeEqualsZero = append(inDegreeEqualsZero, i)
		}
	}

	for len(inDegreeEqualsZero) > 0 {
		head := inDegreeEqualsZero[0]
		res = append(res, head)
		// 找到 这个连接的边 然后删除边的入度
		for _, node := range mapOfCourses[head] {
			inDegreeCounter[node]--
			if inDegreeCounter[node] == 0 {
				inDegreeEqualsZero = append(inDegreeEqualsZero, node)
			}
		}
		inDegreeEqualsZero = inDegreeEqualsZero[1:]
	}
	return res
}
