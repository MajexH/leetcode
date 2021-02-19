package jzoffer

import "testing"

func Test_missingNumber(t *testing.T) {
	t.Log(missingNumber([]int{0, 1, 2, 3, 4, 5, 6, 7, 9}))
}
