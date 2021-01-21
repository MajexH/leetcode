package jzoffer

// 找到 repeatNumber 修改原数组
func findRepeatNumber(nums []int) int {
	for i, num := range nums {
		// 说明现在这个没在他的位置上 要交换
		if i != num {
			// 去交换
			for i != nums[i] {
				// 找到重复
				if num == nums[num] {
					return num
				}
				swap(nums, i, num)
			}
		}
	}
	return -1
}

// 不修改原数组找到 repeatNumber
func findRepeatNumberII(nums []int) int {
	i, j := 1, len(nums)-1

	for i < j {
		mid := (i + j) / 2
		if countNumber(nums, i, mid) > mid-i+1 {
			j = mid
		} else {
			i = mid + 1
		}
	}
	return i
}

func countNumber(nums []int, start, end int) (count int) {
	count = 0
	for _, num := range nums {
		if num >= start && num <= end {
			count++
		}
	}
	return
}

func swap(nums []int, i, j int) {
	if nums[i] == nums[j] {
		return
	}
	nums[i] = nums[i] ^ nums[j]
	nums[j] = nums[i] ^ nums[j]
	nums[i] = nums[i] ^ nums[j]
}
