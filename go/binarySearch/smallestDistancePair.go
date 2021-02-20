package binarySearch

import (
	"container/heap"
	"math"
	"sort"
)

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

// 找到 nums 中第k小一对数之间的最短距离（距离为两数之差）
// heap outOfMemory
func smallestDistancePairWithHeap(nums []int, k int) int {
	hp := &IntHeap{}
	heap.Init(hp)

	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			heap.Push(hp, int(math.Abs(float64(nums[i]-nums[j]))))
			if hp.Len() > k {
				heap.Pop(hp)
			}
		}
	}

	return (*hp)[0]
}

// 最小的距离 一定在 最大距离之间
func smallestDistancePair(nums []int, k int) int {
	if len(nums) == 0 {
		return -1
	}
	sort.Ints(nums)
	// i, j 表示的是 nums 中的 数据差 的范围
	i, j := 0, nums[len(nums)-1]-nums[0]
	for i < j {
		// mid 表示的是中间的差值
		mid := i + (j-i)/2
		// 找到小于等于 mid 的数值差的数量
		count := findDistancePair(nums, mid)

		if count >= k {
			// 因为是小于等于 mid 的数值差的数量 所以可能 mid 是解 也可以是在左边
			j = mid
		} else if count < k {
			i = mid + 1
		}
	}
	return i
}

func findDistancePair(nums []int, distance int) int {
	res := 0
	// 固定右边界
	i, j := 0, 1
	for j < len(nums) {
		// 统计出来的是小于等于 distance 的数量
		for i < j && nums[j]-nums[i] > distance {
			i++
		}
		// 因为是递增的 如果这个时候 1,2,2,3,4 相当于固定右边界 那么排序完的数组 左边能够形成的满足条件的数对 应该是 j - i 个
		res += j - i
		j++
	}
	return res
}
