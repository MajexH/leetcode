package classic

func findMin(nums []int) int {
	if len(nums) == 0 {
		return -1
	}

	i, j := 0, len(nums)-1

	for i < j {
		mid := (i + j) / 2

		if nums[mid] == nums[i] && nums[mid] == nums[j] {
			m := nums[i]
			// 只能循环
			for i <= j {
				m = min(m, nums[i])
				i++
			}
			return m
		} else if nums[mid] > nums[j] {
			// 拐点在右边
			i = mid + 1
		} else if nums[mid] < nums[i] {
			// 拐点在左边或者自己
			j = mid
		} else {
			// 正常的二分
			return nums[i]
		}
	}
	return nums[i]
}
