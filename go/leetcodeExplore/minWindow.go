package leetcodeExplore

func minWindow(s string, t string) string {

	res := ""
	if len(t) > len(s) {
		return res
	}

	mapForS, mapForT := make(map[byte]int), make(map[byte]int)

	for i := 0; i < len(t); i++ {
		mapForT[t[i]]++
	}
	i, j := 0, 0
	for j < len(s) || i < j {
		for j < len(s) && !isEqualMap(mapForS, mapForT) {
			mapForS[s[j]]++
			j++
		}
		if isEqualMap(mapForS, mapForT) && (res == "" || len(res) > j-i) {
			res = s[i:j]
		}
		mapForS[s[i]]--
		i++
	}

	return res
}

func isEqualMap(mapForS, mapForT map[byte]int) bool {
	for k, v := range mapForT {
		if val, ok := mapForS[k]; !ok || val < v {
			return false
		}
	}
	return true
}
