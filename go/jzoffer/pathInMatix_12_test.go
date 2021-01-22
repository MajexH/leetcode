package jzoffer

import "testing"

func Test_exist(t *testing.T) {
	t.Log(exist([][]byte{{'a'}}, "a"))
}
