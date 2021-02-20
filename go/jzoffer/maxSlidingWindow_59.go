package jzoffer

// 用双端开口的 Dequeue
func maxSlidingWindow(nums []int, k int) []int {
	if len(nums) == 0 {
		return []int{}
	}
	dequeue := make([]int, 0)
	res := make([]int, 0)

	for i := 0; i < k; i++ {
		for len(dequeue) > 0 && nums[dequeue[len(dequeue)-1]] <= nums[i] {
			dequeue = dequeue[:len(dequeue)-1]
		}
		dequeue = append(dequeue, i)
	}

	for i := k; i < len(nums); i++ {
		res = append(res, nums[dequeue[0]])
		for len(dequeue) > 0 && nums[dequeue[len(dequeue)-1]] <= nums[i] {
			dequeue = dequeue[:len(dequeue)-1]
		}
		// 判断收尾是否超过距离
		if len(dequeue) > 0 && i-dequeue[0] >= k {
			dequeue = dequeue[1:]
		}
		dequeue = append(dequeue, i)
	}
	res = append(res, nums[dequeue[0]])
	return res
}
