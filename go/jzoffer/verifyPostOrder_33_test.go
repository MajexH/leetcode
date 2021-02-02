package jzoffer

import "testing"

func Test_verifyPostorder(t *testing.T) {
	t.Log(verifyPostorder([]int{1, 3, 2, 6, 5}))
	t.Log(verifyPostorder([]int{1, 6, 3, 2, 5}))
}
