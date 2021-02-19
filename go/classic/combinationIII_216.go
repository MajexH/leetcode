package classic

func combinationSum3(k int, n int) [][]int {
	res := make([][]int, 0)
	recursionCombinationSum3(&res, k, n, []int{}, 1)
	return res
}

func recursionCombinationSum3(res *[][]int, k, n int, tmp []int, start int) {
	if k == 0 {
		if n == 0 {
			cp := make([]int, len(tmp))
			copy(cp, tmp)
			*res = append(*res, cp)
		}
		return
	}

	for i := start; i <= 9; i++ {
		tmp = append(tmp, i)
		recursionCombinationSum3(res, k-1, n-i, tmp, i+1)
		tmp = tmp[:len(tmp)-1]
	}
}
