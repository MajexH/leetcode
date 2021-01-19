package classic

import (
	"strconv"
)

func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	str := strconv.Itoa(x)
	i, j := 0, len(str)-1
	for i < j {
		if str[i] != str[j] {
			return false
		}
		i++
		j--
	}
	return true
}

// isPalindrome1 计算转换之后的数值 与之前的比较
func isPalindrome1(x int) bool {
	if x < 0 {
		return false
	}

	res, rem := 0, x

	for x > 0 {
		res = res*10 + x%10
		x = x / 10
	}
	return res == rem
}
