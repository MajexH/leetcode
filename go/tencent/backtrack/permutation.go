package main

import "fmt"

func main() {
	fmt.Println(permute([]int{1, 2, 3}))
}

func permute(nums []int) [][]int {
	res := make([][]int, 0)
	recursionPermute(&res, &nums, 0)
	return res
}

func recursionPermute(res *[][]int, nums *[]int, start int) {
	if start >= len(*nums) {
		temp := make([]int, len(*nums))
		copy(temp, *nums)
		*res = append(*res, temp)
		return
	}
	for i := start; i < len(*nums); i++ {
		(*nums)[start], (*nums)[i] = (*nums)[i], (*nums)[start]
		recursionPermute(res, nums, start+1)
		(*nums)[start], (*nums)[i] = (*nums)[i], (*nums)[start]
	}
}
