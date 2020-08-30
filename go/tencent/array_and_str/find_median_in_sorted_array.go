package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(findMedianSortedArrays([]int{1, 3}, []int{2, 4}))
}

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	nums := make([]int, len(nums1))
	copy(nums, nums1)
	nums = append(nums, nums2...)
	sort.Ints(nums)
	if len(nums)&1 == 1 {
		return float64(nums[len(nums)/2])
	} else {
		if len(nums) == 0 {
			return 0
		}
		return (float64(nums[len(nums)/2]) + float64(nums[len(nums)/2-1])) / 2
	}
}
