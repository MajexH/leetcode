package main

import "fmt"

func main() {
	fmt.Println(longestPalindrome("babad"))
}

func longestPalindrome(s string) string {
	memo := make([][]bool, len(s))
	for i := 0; i < len(s); i++ {
		memo[i] = make([]bool, len(s))
	}
	res := ""

	for i := len(s) - 1; i >= 0; i-- {
		for j := i; j < len(s); j++ {
			if s[i] == s[j] {
				memo[i][j] = i == j || i+1 == j || memo[i+1][j-1]
			}
			if memo[i][j] && j-i+1 > len(res) {
				res = s[i : j+1]
			}
		}
	}
	return res
}
