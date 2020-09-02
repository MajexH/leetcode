package main

func subsets(nums []int) [][]int {
	res := make([][]int, 0)
	recursionSub(&res, []int{}, nums, 0)
	return res
}

func recursionSub(res *[][]int, temp []int, nums []int, start int) {
	cp := make([]int, len(temp))
	copy(cp, temp)
	*res = append(*res, cp)
	for i := start; i < len(nums); i++ {
		temp = append(temp, nums[i])
		recursionSub(res, temp, nums, i+1)
		temp = temp[:len(temp)-1]
	}
}
