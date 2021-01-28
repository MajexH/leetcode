package classic

import (
	"strconv"
)

func addBinary(a string, b string) string {
	add := 0
	i, j := len(a)-1, len(b)-1
	res := ""
	for i >= 0 || j >= 0 {
		num1, num2 := 0, 0
		if i >= 0 {
			num1 = int(a[i] - '0')
			i--
		}
		if j >= 0 {
			num2 = int(b[j] - '0')
			j--
		}
		tmp := num1 + num2 + add

		add = tmp / 2
		res = strconv.Itoa(tmp%2) + res
	}
	if add != 0 {
		res = strconv.Itoa(add) + res
	}
	return res
}
