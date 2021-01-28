package classic

import "testing"

func Test_minWindow(t *testing.T) {
	t.Log(minWindow("ADOBECODEBANC", "ABC"))
	t.Log(minWindow("a", "a"))
}
