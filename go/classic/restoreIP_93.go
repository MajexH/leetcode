package classic

import (
	"strconv"
	"strings"
)

func restoreIpAddresses(s string) []string {
	res := make([]string, 0)
	recursionRestoreIpAddress(s, &res, 0, []string{}, 0)
	return res
}

func recursionRestoreIpAddress(s string, res *[]string, start int, tmp []string, index int) {
	if index > 4 {
		return
	}
	if start >= len(s) && index == 4 {
		*res = append(*res, strings.Join(tmp, "."))
		return
	}

	for j := start + 1; j <= min(len(s), start+3); j++ {
		if validIpAddress(s[start:j]) {
			tmp = append(tmp, s[start:j])
			recursionRestoreIpAddress(s, res, j, tmp, index+1)
			tmp = tmp[:len(tmp)-1]
		}
	}

}

func validIpAddress(s string) bool {
	if len(s) > 1 && s[0] == '0' || len(s) == 0 {
		return false
	}
	if num, err := strconv.Atoi(s); err != nil || num < 0 || num > 255 {
		return false
	}
	return true
}
