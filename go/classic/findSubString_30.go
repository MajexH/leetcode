package classic

// findSubstring 这个方法是暴力方法
// 由于下面那个方法遍历 map 相当于是先遍历字符串一遍 形成 map 再遍历 map 比较 可以优化这个步骤
// 在生成 map 的同时 直接比较
func findSubstring(s string, words []string) []int {
	if len(s) == 0 || len(words) == 0 {
		return []int{}
	}
	res := make([]int, 0)
	wordsMap := make(map[string]int)
	// 构建 words 的 map
	for _, word := range words {
		wordsMap[word]++
	}

	wordsLen, wordLen := len(words), len(words[0])

	for i := 0; i <= len(s)-wordLen*wordsLen; i++ {
		count := 0
		tmpMap := make(map[string]int)
		// 根据长度选取其中的字符串
		for j := i; j < i+wordsLen*wordLen; j += wordLen {
			str := s[j : j+wordLen]
			// 如果存在 并且 此时 遍历的 str 里面存在的对应的 word 出现的次数小于等于
			// 因为如果超过了 原始的 wordsMap 里面的次数 是不能构成的
			// 而此时 每次遍历的长度是一定的
			if num, ok := wordsMap[str]; ok && num > tmpMap[str] {
				tmpMap[str]++
				count++
			} else {
				// 原始的 words map 里面不存在这个单词 说明这个串是不行的
				break
			}
		}
		if count == wordsLen {
			res = append(res, i)
		}
	}
	return res
}

// findSubstring1 这个方法是暴力方法
// 不停地遍历 words 的整体长度个字符串 得到结果
func findSubstring1(s string, words []string) []int {
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
