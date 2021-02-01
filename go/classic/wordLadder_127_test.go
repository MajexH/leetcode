package classic

import "testing"

func Test_ladderLength(t *testing.T) {
	t.Log(ladderLength("hit", "cog", []string{"hot", "dot", "dog", "lot", "log", "cog"}))
	t.Log(ladderLength("hit", "cog", []string{"hot", "dot", "dog", "lot", "log"}))
}
