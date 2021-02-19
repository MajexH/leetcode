package classic

import (
	"container/heap"
	"sort"
)

type minHeap []int

func (h minHeap) Len() int           { return len(h) }
func (h minHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h minHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *minHeap) Push(x interface{}) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int))
}

func (h *minHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func (h *minHeap) Top() interface{} {
	return (*h)[0]
}

func minMeetingRooms(intervals [][]int) int {
	// 按照开始时间排序
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	// 小顶堆
	intHeap := &minHeap{}
	heap.Init(intHeap)

	for _, interval := range intervals {
		if intHeap.Len() == 0 {
			// push 如 end time
			heap.Push(intHeap, interval[1])
			continue
		}
		// 判断现在的开始时间是否重合
		// 因为最早结束的都不行 后面一定不行
		top := intHeap.Top().(int)
		if top <= interval[0] {
			heap.Remove(intHeap, 0)
		}
		heap.Push(intHeap, interval[1])
	}

	return intHeap.Len()
}
