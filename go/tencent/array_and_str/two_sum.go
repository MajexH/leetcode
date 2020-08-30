package main

import "fmt"

func main() {
	fmt.Println(twoSum([]int{3, 2, 4}, 6))
}

func twoSum(nums []int, target int) []int {
	memo := make(map[int]int)

	for idx, val := range nums {
		if _, ok := memo[target-val]; ok {
			return []int{memo[target-val], idx}
		}
		memo[val] = idx
	}
	return []int{-1, -1}
}
