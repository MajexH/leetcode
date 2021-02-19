package jzoffer

import "testing"

func Test_singleNumber(t *testing.T) {
	t.Log(singleNumber([]int{3, 4, 3, 3}))
	t.Log(singleNumber([]int{9, 1, 7, 9, 7, 9, 7}))
}
