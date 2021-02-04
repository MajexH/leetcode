package jzoffer

import "container/heap"

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] > h[j] }
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

func getLeastNumbers(arr []int, k int) []int {
	intHeap := &IntHeap{}
	heap.Init(intHeap)
	for _, num := range arr {
		heap.Push(intHeap, num)
		if intHeap.Len() > k {
			heap.Pop(intHeap)
		}
	}
	return *intHeap
}

func getLeastNumbersWithPartition(arr []int, k int) []int {
	if k == 0 {
		return []int{}
	}
	i, j := 0, len(arr)-1
	index := partitionLeastNumber(arr, i, j)
	for index != k-1 {
		if index > k-1 {
			j = index - 1
		} else {
			i = index + 1
		}
		index = partitionLeastNumber(arr, i, j)
	}
	return arr[0:k]
}

func partitionLeastNumber(arr []int, start, end int) int {
	base := arr[start]
	i, j := start, end+1

	for true {
		i++
		for i <= end && arr[i] < base {
			i++
		}
		j--
		for j >= 0 && arr[j] > base {
			j--
		}
		if i >= j {
			break
		}
		swap(arr, i, j)
	}
	swap(arr, start, j)
	return j
}
