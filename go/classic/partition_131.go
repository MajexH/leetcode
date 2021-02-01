package classic

// partition131 把 s 分隔成一系列的回文串
func partition131(s string) [][]string {
	res := make([][]string, 0)
	// dp[i][j] 表示 i -> j 的字符串是否是回文串
	dp := make([][]bool, len(s))
	for i := 0; i < len(s); i++ {
		dp[i] = make([]bool, len(s))
	}
	// 这样由于 dp 效率比较低 还不如直接判断回文数
	for i := len(s) - 1; i >= 0; i-- {
		for j := i; j < len(s); j++ {
			if s[i] == s[j] {
				dp[i][j] = i == j || i+1 == j || dp[i+1][j-1]
			}
		}
	}
	recursionPartition131(&res, dp, 0, s, []string{})
	return res
}

func recursionPartition131(res *[][]string, dp [][]bool, start int, s string, tmp []string) {
	if start > len(s) {
		return
	}
	if start == len(s) {
		cp := make([]string, len(tmp))
		copy(cp, tmp)
		*res = append(*res, cp)
		return
	}
	for j := start; j < len(s); j++ {
		if dp[start][j] {
			tmp = append(tmp, s[start:j+1])
			recursionPartition131(res, dp, j+1, s, tmp)
			tmp = tmp[:len(tmp)-1]
		}
	}
}

func partition131_1(s string) [][]string {
	res := make([][]string, 0)
	recursionPartition131_1(&res, 0, s, []string{})
	return res
}

func recursionPartition131_1(res *[][]string, start int, s string, tmp []string) {
	if start > len(s) {
		return
	}
	if start == len(s) {
		cp := make([]string, len(tmp))
		copy(cp, tmp)
		*res = append(*res, cp)
		return
	}
	for j := start; j < len(s); j++ {
		if isPalindromeStr(s[start : j+1]) {
			tmp = append(tmp, s[start:j+1])
			recursionPartition131_1(res, j+1, s, tmp)
			tmp = tmp[:len(tmp)-1]
		}
	}
}

func isPalindromeStr(s string) bool {
	i, j := 0, len(s)-1

	for i < j {
		if s[i] != s[j] {
			return false
		}
		i++
		j--
	}
	return true
}
