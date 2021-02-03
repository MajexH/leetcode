package jzoffer

// 有重复的
func permutation(s string) []string {
	res := make([]string, 0)
	bytesArray := make([]byte, len(s))

	for i := 0; i < len(s); i++ {
		bytesArray[i] = s[i]
	}
	recursionPermutation(&res, bytesArray, 0)
	return res
}

func recursionPermutation(res *[]string, bytes []byte, start int) {
	if start == len(bytes) {
		cp := make([]byte, len(bytes))
		copy(cp, bytes)
		*res = append(*res, string(bytes[:]))
		return
	}
	for i := start; i < len(bytes); i++ {
		if canPermute(bytes, start, i) {
			swapBytes(bytes, start, i)
			recursionPermutation(res, bytes, start+1)
			swapBytes(bytes, start, i)
		}
	}
}

func canPermute(bytes []byte, start, end int) bool {
	for start < end {
		if bytes[start] == bytes[end] {
			return false
		}
		start++
	}
	return true
}

func swapBytes(bytes []byte, i, j int) {
	tmp := bytes[i]
	bytes[i] = bytes[j]
	bytes[j] = tmp
}
