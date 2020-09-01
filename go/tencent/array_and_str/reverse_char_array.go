package main

func reverseString(s []byte) {
	i, j := 0, len(s)-1
	for i < j {
		temp := s[i]
		s[i] = s[j]
		s[j] = temp
		i++
		j--
	}
}
