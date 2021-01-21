package jzoffer

func replaceSpace(s string) string {
	numOfSpace := 0

	for _, char := range s {
		if char == ' ' {
			numOfSpace++
		}
	}

	res := make([]byte, len(s)+numOfSpace*2)

	for i, j := len(res)-1, len(s)-1; i >= 0 && j >= 0; j-- {
		if s[j] != ' ' {
			res[i] = s[j]
			i--
			continue
		}
		res[i] = '0'
		res[i-1] = '2'
		res[i-2] = '%'
		i -= 3
	}

	return string(res)
}
