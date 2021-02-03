package classic

import (
	"strconv"
	"strings"
)

func compareVersion(version1 string, version2 string) int {
	v1, v2 := strings.Split(version1, "."), strings.Split(version2, ".")

	i, j := 0, 0

	for i < len(v1) || j < len(v2) {
		var num1, num2 int
		if i < len(v1) {
			num1, _ = strconv.Atoi(v1[i])
		}
		if j < len(v2) {
			num2, _ = strconv.Atoi(v2[j])
		}
		if num1 > num2 {
			return 1
		} else if num1 < num2 {
			return -1
		}
		i++
		j++
	}
	return 0
}
