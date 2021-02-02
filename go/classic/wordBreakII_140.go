package classic

import "strings"

// 使用递归优化的
func wordBreakII(s string, wordDict []string) []string {
	set := make(map[string]int)
	for _, word := range wordDict {
		set[word] = 1
	}
	memo := make(map[int][]string)
	return recursionWorBreakWithMemo(s, 0, set, memo)
}

func recursionWorBreakWithMemo(s string, start int, set map[string]int, memo map[int][]string) []string {
	if start == len(s) {
		return []string{""}
	}
	if start > len(s) {
		return []string{}
	}
	if val, ok := memo[start]; ok {
		return val
	}
	res := make([]string, 0)
	for i := start + 1; i <= len(s); i++ {
		if _, ok := set[s[start:i]]; ok {
			children := recursionWorBreakWithMemo(s, i, set, memo)
			for _, child := range children {
				if len(child) == 0 {
					res = append(res, s[start:i])
				} else {
					res = append(res, s[start:i]+" "+child)
				}
			}
		}
	}
	memo[start] = res
	return res
}

// 递归的方法做 仍然超时 因为下面这个递归没有用 memo 优化导致的
func wordBreakIIWithRecursion(s string, wordDict []string) []string {
	res := make([]string, 0)
	set := make(map[string]int)
	for _, word := range wordDict {
		set[word] = 1
	}
	recursionWorBreakII(&res, []string{}, s, 0, set)
	return res
}

func recursionWorBreakII(res *[]string, tmp []string, s string, start int, set map[string]int) {
	if start == len(s) {
		*res = append(*res, strings.Join(tmp, " "))
		return
	}
	if start > len(s) {
		return
	}
	for i := start + 1; i <= len(s); i++ {
		if _, ok := set[s[start:i]]; ok {
			tmp = append(tmp, s[start:i])
			recursionWorBreakII(res, tmp, s, i, set)
			tmp = tmp[:len(tmp)-1]
		}
	}
}
