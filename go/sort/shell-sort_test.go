package sort

import "testing"

func Test_shellSort(t *testing.T) {
	a := []int{3, 45, 12, 454, 213, 454, 12312, 1, 454, 25, 314, 5, 4, 1, 2, 43, 4534, 5, 344, 123, 2154, 35, 32, 4}
	shellSort(a)
	t.Log(a)
}
