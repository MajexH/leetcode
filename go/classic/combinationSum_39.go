package classic

func combinationSum(candidates []int, target int) [][]int {
	res := make([][]int, 0)
	recursionCombinationSum(&res, &[]int{}, candidates, target, 0)
	return res
}

func recursionCombinationSum(res *[][]int, tmp *[]int, candidates []int, target, start int) {
	if target == 0 {
		add := make([]int, len(*tmp))
		copy(add, *tmp)
		*res = append(*res, add)
		return
	}
	if target < 0 {
		return
	}
	for i := start; i < len(candidates); i++ {
		*tmp = append(*tmp, candidates[i])
		recursionCombinationSum(res, tmp, candidates, target-candidates[i], i)
		*tmp = (*tmp)[:len(*tmp)-1]
	}
}
