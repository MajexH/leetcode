package main

import "fmt"

func main() {
	fmt.Println(search([]int{3, 1}, 1))
}

func search(nums []int, target int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}

	i, j := 0, len(nums)-1

	for i < j {
		mid := (i + j) / 2

		if nums[mid] == target {
			return mid
		}

		if nums[mid] > nums[j] {
			// 拐点在右边或者自己
			if target > nums[mid] || target < nums[i] {
				i = mid + 1
			} else {
				j = mid - 1
			}
		} else if nums[mid] < nums[i] {
			// 拐点在左边或者自己
			if target < nums[mid] || target > nums[j] {
				j = mid - 1
			} else {
				i = mid + 1
			}
		} else {
			// 二分
			if target > nums[mid] {
				i = mid + 1
			} else {
				j = mid - 1
			}
		}
	}
	if nums[i] == target {
		return i
	}
	return -1
}
