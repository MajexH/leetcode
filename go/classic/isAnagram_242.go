package classic

func isAnagram(s string, t string) bool {
	memo := make([]int, 26)

	for _, char := range s {
		memo[char-'a']++
	}

	for _, char := range t {
		memo[char-'a']--
	}

	for _, num := range memo {
		if num != 0 {
			return false
		}
	}
	return true
}
