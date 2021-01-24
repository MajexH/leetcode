package jzoffer

import "strings"

// isNumber 判断是否符合 3.145e|E
func isNumber(s string) bool {

	s = strings.TrimSpace(s)
	if len(s) == 0 {
		return false
	}

	flag, index := checkNumber(s, 0)
	if index == len(s) {
		return flag
	}
	if s[index] == '.' {
		// 可能存在 s = ".123"
		f, i := checkUnsignedNumber(s, index+1)
		flag = flag || f
		index = i
	}
	if index == len(s) {
		return flag
	}
	if s[index] == 'e' || s[index] == 'E' {
		f, i := checkNumber(s, index+1)
		flag = flag && f
		index = i
	}

	return flag && index == len(s)
}

func checkNumber(s string, start int) (bool, int) {
	if start >= len(s) {
		return false, start
	}
	if s[start] == '+' || s[start] == '-' {
		start++
	}
	return checkUnsignedNumber(s, start)
}

func checkUnsignedNumber(s string, start int) (bool, int) {
	flag := false
	for start < len(s) && s[start] >= '0' && s[start] <= '9' {
		start++
		// 只要有一个匹配就行
		flag = true
	}
	return flag, start
}
