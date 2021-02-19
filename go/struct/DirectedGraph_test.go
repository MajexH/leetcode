package _struct

import (
	"testing"
)

func TestDFS(t *testing.T) {
	dg := NewDirectedGraph(13)
	dg.addEdge(1, 2)
	dg.addEdge(3, 1)
	dg.addEdge(6, 3)
	dg.addEdge(4, 7)
	dg.addEdge(2, 0)
	dg.addEdge(11, 8)
	dg.addEdge(10, 1)
	dg.addEdge(0, 7)
	dg.addEdge(0, 6)

	DFS(dg)
}

func TestHasCycle(t *testing.T) {
	dg := NewDirectedGraph(13)
	dg.addEdge(1, 2)
	dg.addEdge(3, 1)
	dg.addEdge(6, 3)
	dg.addEdge(4, 7)
	dg.addEdge(2, 0)
	dg.addEdge(11, 8)
	dg.addEdge(10, 1)
	dg.addEdge(0, 7)
	dg.addEdge(0, 6)

	t.Log(HasCycle(dg))
}

func TestTopologySortDFS(t *testing.T) {
	dg := NewDirectedGraph(13)
	dg.addEdge(1, 2)
	dg.addEdge(3, 1)
	dg.addEdge(6, 3)
	dg.addEdge(4, 7)
	dg.addEdge(2, 0)
	dg.addEdge(11, 8)
	dg.addEdge(10, 1)
	dg.addEdge(0, 7)

	t.Log(TopologySortDFS(dg))
}

func TestTopologySortWithDegree(t *testing.T) {
	dg := NewDirectedGraph(13)
	dg.addEdge(1, 2)
	dg.addEdge(3, 1)
	dg.addEdge(6, 3)
	dg.addEdge(4, 7)
	dg.addEdge(2, 0)
	dg.addEdge(11, 8)
	dg.addEdge(10, 1)
	dg.addEdge(0, 7)

	t.Log(TopologySortWithDegree(dg))
}

func TestKosarajuSCCStrongConnected(t *testing.T) {
	dg := NewDirectedGraph(13)
	dg.addEdge(1, 2)
	dg.addEdge(3, 1)
	dg.addEdge(6, 3)
	dg.addEdge(4, 7)
	dg.addEdge(2, 0)
	dg.addEdge(11, 8)
	dg.addEdge(10, 1)
	dg.addEdge(0, 7)
	dg.addEdge(0, 6)

	t.Log(KosarajuSCCStrongConnected(dg))
}
