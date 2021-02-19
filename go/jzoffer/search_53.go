package jzoffer

func search(nums []int, target int) int {
	if len(nums) == 0 {
		return 0
	}
	left := binaryLeftSearch(nums, target)

	if left == -1 {
		return 0
	}

	right := binaryRightSearch(nums, target)

	return right - left + 1
}

func binaryLeftSearch(nums []int, target int) int {
	i, j := 0, len(nums)-1

	for i < j {
		mid := (i + j) / 2

		if nums[mid] >= target {
			j = mid
		} else {
			i = mid + 1
		}
	}

	if nums[i] == target {
		return i
	}
	return -1
}

func binaryRightSearch(nums []int, target int) int {
	i, j := 0, len(nums)-1

	for i < j {
		mid := (i + j + 1) / 2

		if nums[mid] <= target {
			i = mid
		} else {
			j = mid - 1
		}
	}

	if nums[i] == target {
		return i
	}
	return -1
}
