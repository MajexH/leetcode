package classic

import (
	"testing"
)

func Test_wordBreakII(t *testing.T) {
	a := wordBreakII("catsanddog", []string{"cat", "cats", "and", "sand", "dog"})
	t.Log(a)
}
