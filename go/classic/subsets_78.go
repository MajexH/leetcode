package classic

func subsets(nums []int) [][]int {
	res := make([][]int, 0)
	recursionSubsets(&res, nums, []int{}, 0)
	return res
}

func recursionSubsets(res *[][]int, nums []int, tmp []int, start int) {
	cp := make([]int, len(tmp))
	copy(cp, tmp)
	*res = append(*res, cp)
	for i := start; i < len(nums); i++ {
		tmp = append(tmp, nums[i])
		recursionSubsets(res, nums, tmp, i+1)
		tmp = tmp[:len(tmp)-1]
	}
}
