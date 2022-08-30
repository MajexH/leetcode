package classic

import (
	"container/heap"
)

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func largestSumAfterKNegations(nums []int, k int) int {
	priorityQueue := &IntHeap{}
	heap.Init(priorityQueue)

	for _, num := range nums {
		heap.Push(priorityQueue, num)
	}

	for ; k > 0; k-- {
		heap.Push(priorityQueue, -(heap.Pop(priorityQueue).(int)))
	}

	res := 0

	for priorityQueue.Len() > 0 {
		res += priorityQueue.Pop().(int)
	}

	return res
}
