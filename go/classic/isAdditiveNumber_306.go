package classic

import (
	"strconv"
	"strings"
)

func isAdditiveNumber(num string) bool {
	for i := 1; i <= len(num)/2; i++ {
		for j := 1; max(i, j) <= len(num)-i-j; j++ {
			if isAdditiveNumberWithIndex(num, i, j) {
				return true
			}
		}
	}
	return false
}

// i, j 分别指带 开始的两个数
func isAdditiveNumberWithIndex(num string, i, j int) bool {
	var num1, num2 int
	var flag bool
	num1, flag = formatNumber(num[:i])
	if !flag {
		return false
	}
	num2, flag = formatNumber(num[i : i+j])
	if !flag {
		return false
	}
	// 保存 num1 + num2 需要的下一个数字
	str := ""
	for index := i + j; index < len(num); index += len(str) {
		// 交换两个数字
		num2 = num1 + num2
		num1 = num2 - num1
		str = strconv.Itoa(num2)
		if !strings.HasPrefix(num[index:], str) {
			return false
		}
	}
	return true
}

func formatNumber(num string) (int, bool) {
	if len(num) == 0 || (len(num) > 1 && num[0] == '0') {
		return -1, false
	}
	res, err := strconv.Atoi(num)
	if err != nil {
		return -1, false
	}
	return res, true
}
