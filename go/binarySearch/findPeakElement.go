package binarySearch

func findPeakElement(nums []int) int {
	i, j := 0, len(nums)-1

	for i < j {
		mid := i + (j-i)/2
		if mid == len(nums)-1 {
			return mid
		}
		// 这样一定 mid 不是 peak peak 一定在之后
		if nums[mid] <= nums[mid+1] {
			i = mid + 1
		} else {
			// mid > mid + 1 说明 peak 要么是 mid 要么在之前
			j = mid
		}
	}

	return i
}
