package classic

func lengthOfLongestSubstring(s string) int {
	length, curLength := 0, 0
	preIndexes := make(map[int32]int)

	for i, char := range s {
		preIndex, ok := preIndexes[char]
		// 不存在或者在现在的最长长度之外
		if !ok || i-preIndex > curLength {
			curLength++
		} else {
			// 更新最长长度
			curLength = i - preIndex
		}
		preIndexes[char] = i
		length = max(length, curLength)
	}

	return length
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
