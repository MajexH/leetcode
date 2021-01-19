package classic

import "strings"

// convert ...
func convert(s string, numRows int) string {
	if numRows == 1 {
		return s
	}

	strs := make([]string, 0, numRows)
	for i := 0; i < numRows; i++ {
		strs = append(strs, "")
	}

	goDown, curRow := false, 0

	for i := 0; i < len(s); i++ {
		// 改变方向
		if i%(numRows-1) == 0 {
			goDown = !goDown
		}

		strs[curRow] += string(s[i])

		if goDown {
			curRow += 1
		} else {
			curRow -= 1
		}
	}

	return strings.Join(strs, "")
}
