package classic

func partition(s string) [][]string {
	res := make([][]string, 0)

	recursion(&res, []string{}, s, 0)

	return res
}

func recursion(res *[][]string, tmp []string, s string, start int) {

	if start >= len(s) {
		cp := make([]string, len(tmp))
		copy(cp, tmp)
		*res = append(*res, cp)
		return
	}

	for i := start; i < len(s); i++ {
		if isPalindrome(s[start : i+1]) {
			tmp = append(tmp, s[start:i+1])
			recursion(res, tmp, s, i + 1)
			tmp = tmp[:len(tmp) - 1]
		}
	}
}

func isPalindrome(str string) bool {

	for i, j := 0, len(str) - 1; i <= j; i, j = i+1, j-1 {
		if str[i] != str[j] {
			return false
		}
	}

	return true
}
