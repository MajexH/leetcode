package jzoffer

import "testing"

func Test_isNumber(t *testing.T) {
	t.Log(isNumber(".12"))
	t.Log(isNumber("e"))
	t.Log(isNumber(".-4"))
}
