package main

import "fmt"

func main() {
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", "flight"}))
}

func longestCommonPrefix(strs []string) string {
	return merge(strs, 0, len(strs)-1)
}

func merge(strs []string, i int, j int) string {
	if i > j {
		return ""
	}
	if i == j {
		return strs[i]
	}
	mid := (i + j) / 2
	left, right := merge(strs, i, mid), merge(strs, mid+1, j)
	return getCommonPrefixOfTwoStr(left, right)
}

func getCommonPrefixOfTwoStr(s1 string, s2 string) string {
	i := 0
	for ; i < len(s1) && i < len(s2); i++ {
		if s1[i] != s2[i] {
			break
		}
	}
	return s1[:i]
}
