package main

func twoSumNew(nums []int, target int) []int {
	memo := make(map[int]int)

	for i, num := range nums {
		if pre, ok := memo[target-num]; ok {
			return []int{pre, i}
		}
		memo[num] = i
	}
	return []int{}
}
