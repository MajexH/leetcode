package jzoffer

// 字符不一定是 a -z
func lengthOfLongestSubstring(s string) int {
	preIndexes := make(map[int32]int)

	curLen, maxLen := 0, 0
	for i, char := range s {
		if preIndex, ok := preIndexes[char-'a']; !ok || i-preIndex > curLen {
			curLen++
		} else {
			curLen = i - preIndexes[char-'a']
		}

		preIndexes[char-'a'] = i
		maxLen = max(maxLen, curLen)
	}
	return maxLen
}
