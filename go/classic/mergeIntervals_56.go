package classic

import (
	"container/list"
	"sort"
)

type Matrix [][]int

func (m Matrix) Len() int {
	return len(m)
}

func (m Matrix) Less(i, j int) bool {
	return m[i][0] < m[j][0]
}

func (m Matrix) Swap(i, j int) {
	m[i], m[j] = m[j], m[i]
}

func merge(m [][]int) [][]int {
	if m == nil || len(m) == 0 {
		return nil
	}
	var intervals Matrix = m
	sort.Sort(intervals)
	res := make([][]int, 0)
	stack := list.New()

	for _, interval := range intervals {
		if stack.Len() == 0 {
			stack.PushBack(interval)
			continue
		}

		top := stack.Remove(stack.Back()).([]int)
		if interval[0] > top[1] {
			stack.PushBack(top)
			stack.PushBack(interval)
			continue
		}

		stack.PushBack([]int{min(interval[0], top[0]), max(interval[1], top[1])})
	}

	for stack.Len() > 0 {
		res = append(res, stack.Remove(stack.Front()).([]int))
	}
	return res
}
