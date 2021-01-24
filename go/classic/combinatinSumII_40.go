package classic

import "sort"

func combinationSum2(candidates []int, target int) [][]int {
	sort.Ints(candidates)
	res := make([][]int, 0)
	recursionCombinationSum2(candidates, target, &res, &[]int{}, 0)
	return res
}

func recursionCombinationSum2(candidates []int, target int, res *[][]int, tmp *[]int, start int) {
	if target < 0 {
		return
	}
	if target == 0 {
		cp := make([]int, len(*tmp))
		copy(cp, *tmp)
		*res = append(*res, cp)
		return
	}

	for i := start; i < len(candidates); i++ {
		// i != start 时说明在当前这个 recursion 中已经是 i++ 过了
		// 即访问后面的数据了 这个时候相当于加入到 tmp 中的第一个数据（当前这个轮次）
		// 如果之前有相同的数据加入过的话 就不用再加入了 所以这儿判断的是 跳过相同的数据
		if i != start {
			for i < len(candidates) && candidates[i-1] == candidates[i] {
				i++
			}
		}
		if i >= len(candidates) {
			break
		}
		*tmp = append(*tmp, candidates[i])
		recursionCombinationSum2(candidates, target-candidates[i], res, tmp, i+1)
		*tmp = (*tmp)[:len(*tmp)-1]
	}
}
