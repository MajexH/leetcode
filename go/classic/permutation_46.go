package classic

func permute(nums []int) [][]int {
	res := make([][]int, 0)
	recursionPermute(&res, 0, nums)
	return res
}

func recursionPermute(res *[][]int, start int, nums []int) {
	if start == len(nums) {
		cp := make([]int, len(nums))
		copy(cp, nums)
		*res = append(*res, cp)
		return
	}
	for i := start; i < len(nums); i++ {
		swap(nums, i, start)
		recursionPermute(res, start+1, nums)
		swap(nums, i, start)
	}
}
