package classic

func combine(n int, k int) [][]int {
	res := make([][]int, 0)
	recursionCombine(&res, n, k, 1, []int{})
	return res
}

func recursionCombine(res *[][]int, n, k, start int, tmp []int) {
	if k == 0 {
		cp := make([]int, len(tmp))
		copy(cp, tmp)
		*res = append(*res, cp)
	}
	for i := start; i <= n; i++ {
		tmp = append(tmp, i)
		recursionCombine(res, n, k-1, i+1, tmp)
		tmp = tmp[:len(tmp)-1]
	}
}
