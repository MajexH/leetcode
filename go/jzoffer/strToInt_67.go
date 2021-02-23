package jzoffer

import (
	"math"
	"strings"
)

func strToInt(str string) int {
	str = strings.TrimSpace(str)
	if len(str) <= 0 {
		return 0
	}
	res := 0
	i := 0
	minus := false

	switch str[0] {
	case '-':
		minus = true
		fallthrough
	case '+':
		i++
	}

	for ; i < len(str); i++ {
		if str[i] > '9' || str[i] < '0' {
			break
		}

		add := int(str[i] - '0')

		// 处理溢出
		if res > (math.MaxInt32/10) || (res == (math.MaxInt32/10) && (add > math.MaxInt32-(math.MaxInt32/10)*10)) {
			if minus {
				return math.MinInt32
			}
			return math.MaxInt32
		}

		if res < (math.MinInt32/10) || (res == (math.MinInt32/10) && (add < math.MinInt32-(math.MinInt32/10)*10)) {
			return math.MinInt32
		}
		res = res*10 + add
	}
	if minus {
		return -res
	}
	return res
}
