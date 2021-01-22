package classic

// findSubstring 这个方法是暴力方法
// 不停地遍历 words 的整体长度个字符串 得到结果
func findSubstring(s string, words []string) []int {
	if len(s) == 0 || len(words) == 0 {
		return []int{}
	}

	res := make([]int, 0)

	wordsMap := make(map[string]int)
	for _, word := range words {
		if count, ok := wordsMap[word]; ok {
			wordsMap[word] = count + 1
		} else {
			wordsMap[word] = 1
		}
	}
	// 选取的总长度
	length := len(words[0]) * len(words)

	for i := 0; i <= len(s)-length; i += 1 {
		m2 := makeMap(s[i:i+length], len(words[0]))
		if equalMap(wordsMap, m2) {
			res = append(res, i)
		}
	}

	return res
}

func makeMap(s string, wordLength int) map[string]int {
	res := make(map[string]int)

	for i := 0; i <= len(s)-wordLength; i += wordLength {
		word := s[i : i+wordLength]
		if count, ok := res[word]; ok {
			res[word] = count + 1
		} else {
			res[word] = 1
		}
	}
	return res
}

func equalMap(m1, m2 map[string]int) bool {
	for key, val := range m1 {
		if v2, ok := m2[key]; !ok || v2 != val {
			return false
		}
	}
	return true
}
