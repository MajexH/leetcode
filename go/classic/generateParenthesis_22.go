package classic

func generateParenthesis(n int) []string {
	res := make([]string, 0)
	recursionGenerate(&res, "", n, n)
	return res
}

func recursionGenerate(res *[]string, tmp string, left, right int) {
	if left == 0 && right == 0 {
		*res = append(*res, tmp)
		return
	}
	if left > 0 {
		recursionGenerate(res, tmp+"(", left-1, right)
	}
	if right > left {
		recursionGenerate(res, tmp+")", left, right-1)
	}
}
