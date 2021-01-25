package jzoffer

func exchange(nums []int) []int {
	if nums == nil || len(nums) == 0 {
		return []int{}
	}

	i, j := 0, len(nums)-1

	for i < j {
		// 前面是奇数就跳过
		if nums[i]&1 == 1 {
			i++
			continue
		}
		if nums[j]&1 == 0 {
			j--
			continue
		}
		swap(nums, i, j)
	}

	return nums
}
