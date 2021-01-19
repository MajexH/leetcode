package classic

func isMatch(s string, p string) bool {
	return recursionIsMatch(s, p, 0, 0)
}

func recursionIsMatch(s, p string, sIndex, pIndex int) bool {
	// 完全匹配
	if sIndex == len(s) && pIndex == len(p) {
		return true
	}
	// 越界 pattern 匹配完了一定有问题
	if pIndex == len(p) && sIndex != len(s) {
		return false
	}

	if pIndex < len(p)-1 && p[pIndex+1] == '*' {
		// 匹配
		if pIndex < len(p) && sIndex < len(s) && (p[pIndex] == s[sIndex] || p[pIndex] == '.') {
			return recursionIsMatch(s, p, sIndex, pIndex+2) || // 匹配0次 因为 * 代表 0 -> 多次
				recursionIsMatch(s, p, sIndex+1, pIndex+2) || // 匹配1次
				recursionIsMatch(s, p, sIndex+1, pIndex) // 匹配多次
		} else {
			// 如果不匹配 则跳过
			return recursionIsMatch(s, p, sIndex, pIndex+2)
		}
	}
	// 现在的字符是匹配的
	if pIndex < len(p) && sIndex < len(s) && (p[pIndex] == s[sIndex] || p[pIndex] == '.') {
		return recursionIsMatch(s, p, sIndex+1, pIndex+1)
	}
	return false
}
