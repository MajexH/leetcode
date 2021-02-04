package jzoffer

import (
	"testing"
)

func Test_getLeastNumbers(t *testing.T) {
	t.Log(getLeastNumbers([]int{0, 0, 0, 2, 0, 5}, 0))
	t.Log(getLeastNumbers([]int{3, 2, 1}, 2))
}
