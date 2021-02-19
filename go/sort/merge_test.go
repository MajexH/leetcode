package sort

import "testing"

func Test_mergeTwoArray(t *testing.T) {
	a := []int{1, 2, 3, 0, 0, 0}
	mergeTwoArray(a, 3, []int{2, 5, 6}, 3)
	t.Log(a)
}
