package _struct

import "errors"

var (
	HaveNoWeight = errors.New("cannot find weight")
)

type node struct {
	next   *node // 下一条边
	id     int   // 连接的边的节点ID
	weight int   // 权重
}

// Graph 无向图
type Graph struct {
	graph map[int]*node // 边节点
}

func NewGraph() *Graph {
	return &Graph{
		graph: make(map[int]*node),
	}
}

// AddEdge 加入两条边
func (g *Graph) AddEdge(from, to, weight int) {
	g.addOneEdge(from, to, weight)
	g.addOneEdge(to, from, weight)
}

func (g *Graph) getLineWeight(from, to int) (int, error) {
	if _, ok := g.graph[from]; !ok {
		return -1, HaveNoWeight
	}
	head := g.graph[from]

	for head != nil {
		if head.id == to {
			return head.weight, nil
		}
		head = head.next
	}
	return -1, HaveNoWeight
}

func (g *Graph) addOneEdge(from, to, weight int) {
	// 如果不存在这个节点 说明要在这个节点上找到
	if _, ok := g.graph[from]; !ok {
		g.graph[from] = &node{
			next:   nil,
			id:     to,
			weight: weight,
		}
		return
	}
	head := g.graph[from]
	for head.next != nil {
		head = head.next
	}
	head.next = &node{
		next:   nil,
		id:     to,
		weight: weight,
	}
}
