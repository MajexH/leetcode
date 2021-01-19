package classic

import (
	"strings"
)

var (
	memo = make(map[int]string)
	keys []int
)

func init() {
	memo[1] = "I"
	memo[4] = "IV"
	memo[5] = "V"
	memo[9] = "IX"
	memo[10] = "X"
	memo[40] = "XL"
	memo[50] = "L"
	memo[90] = "XC"
	memo[100] = "C"
	memo[400] = "CD"
	memo[500] = "D"
	memo[900] = "CM"
	memo[1000] = "M"

	keys = []int{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}
}

func intToRoman(num int) string {
	res := strings.Builder{}

	for _, key := range keys {
		for num >= key {
			res.WriteString(memo[key])
			num -= key
		}
	}
	return res.String()
}
