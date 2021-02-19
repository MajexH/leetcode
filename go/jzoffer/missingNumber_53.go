package jzoffer

// 二分查找 在一个连续递增数组中 存在一个确实的数字
func missingNumber(nums []int) int {
	i, j := 0, len(nums)-1

	for i <= j {
		// 数字的下标应该和数字想等
		mid := (i + j) / 2

		if nums[mid] == mid {
			i = mid + 1
		} else {
			j = mid - 1
		}
	}

	return i
}
