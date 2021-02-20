package classic

import (
	"container/heap"
	"math"
)

// An Item is something we manage in a priority queue.
type Item struct {
	value int // The value of the item; arbitrary.
	// value 对应的是对应的数据的值
	priority int // The priority of the item in the queue.
	// 这里 priority 表示的对应的频数
	// The index is needed by update and is maintained by the heap.Interface methods.
	index int // The index of the item in the heap.
}

// A PriorityQueue implements heap.Interface and holds Items.
type PriorityQueue []*Item

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	// We want Pop to give us the highest, not lowest, priority so we use greater than here.
	return pq[i].priority > pq[j].priority
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
	pq[i].index = i
	pq[j].index = j
}

func (pq *PriorityQueue) Push(x interface{}) {
	n := len(*pq)
	item := x.(*Item)
	item.index = n
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil  // avoid memory leak
	item.index = -1 // for safety
	*pq = old[0 : n-1]
	return item
}

// update modifies the priority and value of an Item in the queue.
func (pq *PriorityQueue) update(item *Item, value int, priority int) {
	item.value = value
	item.priority = priority
	heap.Fix(pq, item.index)
}

// 找到一个最短的子数组 其度与最大的数组相同
// 数组的度是指 任一元素出现的频数的最大值
// 这个方法太麻烦 在于要不停的维护一个 priority 去保持当前窗口的最大的度
func findShortestSubArrayOld(nums []int) int {
	degree := calculateArrayDegree(nums)

	minLen := math.MaxInt32
	pq := &PriorityQueue{}
	heap.Init(pq)

	memo := make(map[int]*Item)

	left, right := 0, 0

	for right < len(nums) {
		if item, ok := memo[nums[right]]; ok {
			item.priority++
			heap.Fix(pq, item.index)
		} else {
			item := &Item{
				value:    nums[right],
				priority: 1,
				index:    0,
			}
			heap.Push(pq, item)
			memo[nums[right]] = item
		}

		for (*pq)[0].priority == degree {
			item, _ := memo[nums[left]]
			item.priority--
			if item.priority == 0 {
				delete(memo, nums[left])
			}
			minLen = min(minLen, right-left+1)
			left++
		}

		right++
	}

	return minLen
}

func calculateArrayDegree(nums []int) int {
	degree := 0

	memo := make(map[int]int)

	for _, num := range nums {
		memo[num]++

		degree = max(degree, memo[num])
	}
	return degree
}
