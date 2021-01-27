package classic

func permuteUnique(nums []int) [][]int {
	res := make([][]int, 0)
	recursionPermutationII(&res, 0, nums)
	return res
}

func recursionPermutationII(res *[][]int, start int, nums []int) {
	if start == len(nums) {
		cp := make([]int, len(nums))
		copy(cp, nums)
		*res = append(*res, cp)
		return
	}
	for i := start; i < len(nums); i++ {
		if canUniquePermute(nums, start, i) {
			swap(nums, i, start)
			recursionPermutationII(res, start+1, nums)
			swap(nums, i, start)
		}
	}
}

func canUniquePermute(nums []int, start, end int) bool {
	for i := start; i < end; i++ {
		if nums[i] == nums[end] {
			return false
		}
	}
	return true
}
