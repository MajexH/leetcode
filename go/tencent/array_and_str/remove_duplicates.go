package main

import "fmt"

func main() {
	a := []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	fmt.Println(removeDuplicates(a), a)
}

func removeDuplicates(nums []int) int {
	fast, last := 0, 0

	for fast < len(nums) {
		for fast < len(nums) && nums[fast] == nums[last] {
			fast++
		}
		if fast == len(nums) {
			break
		}
		last++
		nums[last] = nums[fast]
	}

	return last + 1
}
