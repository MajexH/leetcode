package jzoffer

func isMatch(s string, p string) bool {
	return recursionIsMatch(s, p, 0, 0)
}

func recursionIsMatch(s, p string, sIndex, pIndex int) bool {
	if sIndex == len(s) && pIndex == len(p) {
		return true
	}

	if pIndex == len(p) && sIndex != len(s) || sIndex > len(s) {
		return false
	}

	if pIndex < len(p)-1 && p[pIndex+1] == '*' {
		// 如果匹配
		if p[pIndex] == '.' || (sIndex < len(s) && (s[sIndex] == p[pIndex])) {
			return recursionIsMatch(s, p, sIndex, pIndex+2) || // 匹配0次
				recursionIsMatch(s, p, sIndex+1, pIndex+2) || // 匹配一次
				recursionIsMatch(s, p, sIndex+1, pIndex) // 匹配多次
		} else {
			// 因为是 * 不匹配就跳过
			return recursionIsMatch(s, p, sIndex, pIndex+2)
		}
	}

	if p[pIndex] == '.' || (sIndex < len(s) && (s[sIndex] == p[pIndex])) {
		// 匹配
		return recursionIsMatch(s, p, sIndex+1, pIndex+1)
	}

	return false
}
