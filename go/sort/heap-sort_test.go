package sort

import "testing"

func TestHeap_Sort(t *testing.T) {
	a := []int{654, 532141, 443, 543, 56564, 65, 312, 4, 325, 345, 344, 123, 412, 543, 534, 532, 451, 24, 124, 1, 43, 5435}
	// 因为是小顶堆 所以是从大到小
	NewHeap(a).Sort()
	t.Log(a)
	NewHeapWithCompare(a, func(a, b int) bool {
		return b > a
	}).Sort()
	t.Log(a)
}
