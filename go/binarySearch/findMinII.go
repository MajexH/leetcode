package binarySearch

import "math"

// 旋转排序数组 可能存在重复值
func findMinII(nums []int) int {
	i, j := 0, len(nums)-1

	for i < j {
		mid := i + (j-i)/2

		if nums[mid] == nums[i] && nums[j] == nums[mid] {
			minNum := math.MaxInt32

			for i <= j {
				minNum = min(minNum, nums[i])
				i++
			}
			return minNum
		}

		// 拐点在右边
		if nums[mid] > nums[j] {
			i = mid + 1
		} else if nums[mid] < nums[i] {
			j = mid
		} else {
			return nums[i]
		}
	}
	return nums[i]
}
