package jzoffer

import "testing"

func Test_isMatch(t *testing.T) {
	t.Log(isMatch("ab", ".*c"))
}
