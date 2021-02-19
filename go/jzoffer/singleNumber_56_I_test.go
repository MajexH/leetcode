package jzoffer

import (
	"testing"
)

func Test_singleNumbers(t *testing.T) {
	t.Log(singleNumbers([]int{4, 1, 4, 6}))
	t.Log(singleNumbers([]int{1, 2, 10, 4, 1, 4, 3, 3}))
}
