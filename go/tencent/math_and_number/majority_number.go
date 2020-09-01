package main

func majorityElement(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	elem, counter := nums[0], 1

	for i := 1; i < len(nums); i++ {
		if nums[i] == elem {
			counter++
		} else if counter > 0 {
			counter--
		} else {
			elem = nums[i]
			counter = 1
		}
	}
	return elem
}
