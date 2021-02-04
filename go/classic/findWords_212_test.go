package classic

import (
	"testing"
)

func Test_findWords(t *testing.T) {
	t.Log(findWords([][]byte{
		{'o', 'a', 'a', 'n'},
		{'e', 't', 'a', 'e'},
		{'i', 'h', 'k', 'r'},
		{'i', 'f', 'l', 'v'},
	}, []string{"oath", "pea", "eat", "rain"}))

	t.Log(findWords([][]byte{
		{'a'},
	}, []string{"a"}))
}
