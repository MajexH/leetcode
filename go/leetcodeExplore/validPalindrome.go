package leetcodeExplore

import "unicode"

func isPalindrome(s string) bool {
	i, j := 0, len(s)-1

	for i < j {
		left := rune(s[i])
		for i < j && !(unicode.IsDigit(left) || unicode.IsLetter(left)) {
			i++
			left = rune(s[i])
		}
		right := rune(s[j])
		for i < j && !(unicode.IsDigit(right) || unicode.IsLetter(right)) {
			j--
			right = rune(s[j])
		}

		if unicode.ToLower(left) != unicode.ToLower(right) {
			return false
		}
		i++
		j--
	}

	return true
}
