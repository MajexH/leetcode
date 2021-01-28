package classic

func checkEqualMap(mapForT, window map[int32]int) bool {
	for k, v := range mapForT {
		if count, ok := window[k]; !ok || count < v {
			return false
		}
	}
	return true
}

func minWindow(s string, t string) string {
	i, j := 0, 0
	res := ""
	mapForT := make(map[int32]int)

	for _, char := range t {
		mapForT[char]++
	}

	window := make(map[int32]int)

	for j < len(s) || i < j {
		for j < len(s) && !checkEqualMap(mapForT, window) {
			window[int32(s[j])]++
			j++
		}
		if checkEqualMap(mapForT, window) && (res == "" || len(res) > j-i) {
			res = s[i:j]
		}
		window[int32(s[i])]--
		i++
	}
	return res
}
