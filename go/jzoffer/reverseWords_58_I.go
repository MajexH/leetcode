package jzoffer

import "strings"

func reverseWords(s string) string {
	s = strings.TrimSpace(s)

	strs := strings.Split(s, " ")
	res := make([]string, 0)

	for _, str := range strs {
		if len(str) == 0 || str == " " {
			continue
		}
		res = append([]string{str}, res...)
	}
	return strings.Join(res, " ")
}
