package jzoffer

import "sort"

// 由于大小王(0)可以看成任何数字 所以其实就是看中间的 gap 是否能够填满
func isStraight(nums []int) bool {
	sort.Ints(nums)

	numOfZeros := 0
	gap := 0

	for i, num := range nums {
		if num == 0 {
			numOfZeros++
			continue
		}

		if i < len(nums)-1 {
			if nums[i+1] == nums[i] {
				return false
			}
			gap += nums[i+1] - num - 1
		}
	}
	return numOfZeros >= gap
}
