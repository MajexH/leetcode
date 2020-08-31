package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4}))
}

func threeSum(nums []int) [][]int {
	res := make([][]int, 0)
	if nums == nil || len(nums) < 3 {
		return res
	}
	sort.Ints(nums)
	// 跳过相同的数字 防止重复
	for i, num := range nums {
		if canGenerate(nums, i) {
			for _, twoNumberArray := range findTwoSum(nums, -num, i+1) {
				if len(twoNumberArray) > 0 {
					res = append(res, []int{num, twoNumberArray[0], twoNumberArray[1]})
				}
			}
		}
	}
	return res
}

func canGenerate(nums []int, start int) bool {
	if start > 0 && nums[start-1] == nums[start] {
		return false
	}
	return true
}

// 用之前的 map 的方式做 可能会存在重复 因此这儿用二分来做
func findTwoSum(nums []int, target int, start int) [][]int {
	res := make([][]int, 0)
	i, j := start, len(nums)-1
	for i < j {
		tempSum := nums[i] + nums[j]
		if tempSum > target {
			j--
		} else if tempSum < target {
			i++
		} else {
			// 相等 需要跳过相等的
			res = append(res, []int{nums[i], nums[j]})
			for i < j && nums[i] == nums[i+1] {
				i++
			}
			// 跳到下一个
			i++

			for j > i && nums[j] == nums[j-1] {
				j--
			}
			j--
		}
	}
	return res
}
