package classic

func insert(intervals [][]int, newInterval []int) [][]int {
	res := make([][]int, 0)
	left, right := newInterval[0], newInterval[1]
	flag := true
	for _, interval := range intervals {
		if interval[1] < left {
			res = append(res, interval)
			continue
		}
		if interval[0] > right {
			if flag {
				res = append(res, []int{left, right})
				flag = false
			}
			res = append(res, interval)
			continue
		}
		// 这个时候
		left = min(left, interval[0])
		right = max(right, interval[1])
	}
	if flag {
		res = append(res, []int{left, right})
	}
	return res
}
