package classic

func searchRange(nums []int, target int) []int {
	if nums == nil || len(nums) == 0 {
		return []int{-1, -1}
	}

	left := leftSearch(nums, target)
	if left == -1 {
		return []int{-1, -1}
	}
	return []int{left, rightSearch(nums, target)}
}

func leftSearch(nums []int, target int) int {
	i, j := 0, len(nums)-1

	for i < j {
		mid := (i + j) / 2
		if nums[mid] == target {
			j = mid
		} else if nums[mid] > target {
			j = mid - 1
		} else {
			i = mid + 1
		}
	}

	if nums[i] == target {
		return i
	}
	return -1
}

func rightSearch(nums []int, target int) int {
	i, j := 0, len(nums)-1

	for i < j {
		mid := (i + j + 1) / 2
		if nums[mid] == target {
			i = mid
		} else if nums[mid] > target {
			j = mid - 1
		} else {
			i = mid + 1
		}
	}

	if nums[i] == target {
		return i
	}
	return -1
}
