package jzoffer

func reverseLeftWords(s string, n int) string {
	n = n % len(s)

	return s[n:] + s[:n]
}
