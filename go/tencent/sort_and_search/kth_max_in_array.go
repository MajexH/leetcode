package main

import "fmt"

func main() {
	fmt.Println(findKthLargest([]int{1}, 1))
}

func findKthLargest(nums []int, k int) int {
	i, j := 0, len(nums)-1
	index := partition(nums, i, j)
	for index != k-1 {
		if index > k-1 {
			j = index - 1
		} else {
			i = index + 1
		}
		index = partition(nums, i, j)
	}
	return nums[index]
}

func partition(nums []int, start, end int) int {
	base := nums[start]
	i, j := start+1, end
	for true {
		for i <= end && nums[i] >= base {
			i++
			if i == end {
				break
			}
		}
		for j > start && nums[j] <= base {
			j--
			if j == start {
				break
			}
		}
		if i >= j {
			break
		}
		nums[i], nums[j] = nums[j], nums[i]
	}
	nums[start], nums[j] = nums[j], nums[start]
	return j
}
