package jzoffer

func firstUniqChar(s string) byte {
	memo := make(map[int32]int)

	for _, char := range s {
		memo[char]++
	}

	for _, char := range s {
		if memo[char] == 1 {
			return byte(char)
		}
	}
	return ' '
}
