package classic

import "sort"

func subsetsWithDup(nums []int) [][]int {
	sort.Ints(nums)
	res := make([][]int, 0)
	recursionSubsetWithDup(&res, []int{}, nums, 0)
	return res
}

func recursionSubsetWithDup(res *[][]int, tmp []int, nums []int, start int) {
	cp := make([]int, len(tmp))
	copy(cp, tmp)
	*res = append(*res, cp)

	for i := start; i < len(nums); i++ {
		if canRecursionSubset(nums, start, i) {
			tmp = append(tmp, nums[i])
			recursionSubsetWithDup(res, tmp, nums, i+1)
			tmp = tmp[:len(tmp)-1]
		}
	}
}

func canRecursionSubset(nums []int, start, end int) bool {
	for i := start; i < end; i++ {
		if nums[i] == nums[end] {
			return false
		}
	}
	return true
}
