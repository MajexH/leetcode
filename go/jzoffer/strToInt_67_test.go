package jzoffer

import "testing"

func Test_strToInt(t *testing.T) {
	t.Log(strToInt("42"))
	t.Log(strToInt("   -42"))
	t.Log(strToInt("4193 with words"))
	t.Log(strToInt("words and 987"))
	t.Log(strToInt("-91283472332"))
}
