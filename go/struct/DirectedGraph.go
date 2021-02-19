package _struct

import "fmt"

// 有向图
type DirectedGraph struct {
	edges [][]int
	nodes int
}

func NewDirectedGraph(nodes int) *DirectedGraph {
	return &DirectedGraph{
		edges: make([][]int, nodes),
		nodes: nodes,
	}
}

func (dg *DirectedGraph) addEdge(start, end int) {
	dg.edges[start] = append(dg.edges[start], end)
}

func (dg *DirectedGraph) adj(node int) []int {
	return dg.edges[node]
}

func (dg *DirectedGraph) GetNodes() int {
	return dg.nodes
}

func (dg *DirectedGraph) Reverse() *DirectedGraph {
	res := &DirectedGraph{
		edges: make([][]int, dg.nodes),
		nodes: dg.nodes,
	}
	for i := 0; i < dg.nodes; i++ {
		for _, j := range dg.adj(i) {
			res.addEdge(j, i)
		}
	}
	return res
}

func DFS(dg *DirectedGraph) {
	memo := make([]bool, dg.GetNodes())
	for i := 0; i < dg.GetNodes(); i++ {
		dfsRecursion(dg, i, &memo)
		fmt.Println()
	}
}

func dfsRecursion(dg *DirectedGraph, start int, memo *[]bool) {
	(*memo)[start] = true
	fmt.Printf("%d ", start)
	for _, node := range dg.adj(start) {
		if !(*memo)[node] {
			dfsRecursion(dg, node, memo)
		}
	}
}

// 判断一个有向图是否成环
func HasCycle(dg *DirectedGraph) bool {
	// 保存是否访问过
	marked := make([]bool, dg.GetNodes())
	// 如果一个节点在某次访问中被访问了两次 那么一定会成环
	stack := make([]bool, dg.GetNodes())
	for i := 0; i < dg.GetNodes(); i++ {
		if !marked[i] {
			if hasCycleDFS(dg, i, &marked, &stack) {
				return true
			}
		}
	}
	return false
}

func hasCycleDFS(dg *DirectedGraph, start int, marked, stack *[]bool) bool {
	(*marked)[start] = true
	(*stack)[start] = true
	for _, node := range dg.adj(start) {
		if !(*marked)[node] {
			if hasCycleDFS(dg, node, marked, stack) {
				return true
			}
		} else if (*stack)[node] {
			// 成环
			return true
		}
	}
	(*stack)[start] = false
	return false
}

// 图的拓扑排序
// 两种方法 一种是dfs逆后续排列 一种是出度 入度排列
func TopologySortDFS(dg *DirectedGraph) []int {
	// 逆后续排列
	marked := make([]bool, dg.GetNodes())
	// 逆后续排列的栈
	res := make([]int, 0)

	for i := 0; i < dg.GetNodes(); i++ {
		if !marked[i] {
			recursionTopologySortDFS(dg, &res, marked, i)
		}
	}
	reversedOrder := make([]int, len(res))

	for i, j := 0, len(res)-1; j >= 0; i, j = i+1, j-1 {
		reversedOrder[i] = res[j]
	}
	// 因为 res 是栈 所以其实际顺序应该是返回的逆序
	return reversedOrder
}

// slice 本身就是指针
func recursionTopologySortDFS(dg *DirectedGraph, res *[]int, marked []bool, start int) {
	marked[start] = true
	for _, node := range dg.adj(start) {
		if !marked[node] {
			recursionTopologySortDFS(dg, res, marked, node)
		}
	}
	*res = append(*res, start)
}

// 统计节点的度数 然后不停的遍历即可
func TopologySortWithDegree(dg *DirectedGraph) []int {
	res := make([]int, 0)
	// 因为是 拓扑排序 所以是入度为 0
	inDegrees := make([]int, dg.GetNodes())

	for i := 0; i < dg.GetNodes(); i++ {
		// 节点入度++
		for _, end := range dg.adj(i) {
			inDegrees[end]++
		}
	}
	// 找到入度为 0 的点 这些都是开始点
	inDegreeEqualsZero := make([]int, 0)
	for i, inDegree := range inDegrees {
		if inDegree == 0 {
			inDegreeEqualsZero = append(inDegreeEqualsZero, i)
		}
	}

	for len(inDegreeEqualsZero) > 0 {
		top := inDegreeEqualsZero[0]
		inDegreeEqualsZero = inDegreeEqualsZero[1:]
		for _, end := range dg.adj(top) {
			inDegrees[end]--
			if inDegrees[end] == 0 {
				inDegreeEqualsZero = append(inDegreeEqualsZero, end)
			}
		}
		res = append(res, top)
	}

	return res
}

// 有向图的强连通分量 kosarajuSCC 算法实现的强连通分量
func KosarajuSCCStrongConnected(dg *DirectedGraph) []int {
	// 强连通分量表示的是 一组点 能够互相访问到 形成自闭环

	// 强连通分量的标识符，同一个强连通分量 会有一个标识符
	ids := make([]int, dg.nodes)
	// 强连通分量的标志
	count := 0
	marked := make([]bool, dg.nodes)

	// 逆后续排列
	reverseOrder := TopologySortDFS(dg.Reverse())

	for _, node := range reverseOrder {
		if !marked[node] {
			dfsKosarajuSCCStrongConnected(dg, marked, node, count, ids)
			count++
		}
	}
	return ids
}

func dfsKosarajuSCCStrongConnected(dg *DirectedGraph, marked []bool, start int, count int, ids []int) {
	ids[start] = count
	marked[start] = true
	for _, node := range dg.adj(start) {
		if !marked[node] {
			dfsKosarajuSCCStrongConnected(dg, marked, node, count, ids)
		}
	}
}
