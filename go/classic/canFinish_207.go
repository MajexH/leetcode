package classic

import "container/list"

// canFinish 使用拓扑排序 拓扑排序的一种解法是 逆后续
// 还有一种解法是 不停的遍历 入度 为 0 的点
func canFinish(numCourses int, prerequisites [][]int) bool {

	// 入度为 0 的点为起点
	inDegree := make([]int, numCourses)
	for _, prerequisite := range prerequisites {
		// 让有向图的接受线的一端 入度++
		inDegree[prerequisite[0]]++
	}

	// 保存入度为 0 的点
	inDegreeEqualZero := list.New()
	for i, in := range inDegree {
		if in == 0 {
			inDegreeEqualZero.PushBack(i)
		}
	}

	// 遍历入度为 0 的点
	// 每次删除一条边 判断下一个点 是否入度为0 入度为 0 加入到 map 中 不停的遍历 直到没有点
	for inDegreeEqualZero.Len() > 0 {
		node := inDegreeEqualZero.Remove(inDegreeEqualZero.Front()).(int)
		for _, prerequisite := range prerequisites {
			if node == prerequisite[1] {
				inDegree[prerequisite[0]]--
				if inDegree[prerequisite[0]] == 0 {
					inDegreeEqualZero.PushBack(prerequisite[0])
				}
			}
		}
	}
	for i := 0; i < numCourses; i++ {
		// 这个地方说明还有点相连，因此是无法完成的
		if inDegree[i] != 0 {
			return false
		}
	}
	return true
}

// canFinish 实际上是拓扑排序
// 拓扑排序是不能成环的 实际上就是看是否存在环形节点
func canFinishWithDfs(numCourses int, prerequisites [][]int) bool {
	// 有向图
	mapOfCourses := make([][]int, numCourses)
	for i := 0; i < numCourses; i++ {
		mapOfCourses[i] = make([]int, 0)
	}
	for _, prerequisite := range prerequisites {
		mapOfCourses[prerequisite[1]] = append(mapOfCourses[prerequisite[1]], prerequisite[0])
	}
	// 保存已经访问过的节点 这样可以避免重复访问
	totalMemo := make([]bool, numCourses)
	for i := 0; i < numCourses; i++ {
		if !dfsCanFinish(mapOfCourses, make([]bool, numCourses), totalMemo, i) {
			return false
		}
	}
	return true
}

// 通过 dfs 的方法判断是否成环
// 用 memo 来记录一次循环中访问的节点
func dfsCanFinish(mapOfCourses [][]int, memo, totalMemo []bool, start int) bool {
	// 访问过的地方 是不会成环的
	if totalMemo[start] {
		return true
	}
	totalMemo[start] = true
	memo[start] = true
	for _, adj := range mapOfCourses[start] {
		if !memo[adj] {
			// 截断 有环直接返回
			if !dfsCanFinish(mapOfCourses, memo, totalMemo, adj) {
				return false
			}
		} else {
			// 这个地方就是找到了环
			return false
		}
	}
	memo[start] = false
	return true
}
