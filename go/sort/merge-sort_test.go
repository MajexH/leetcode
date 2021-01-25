package sort

import "testing"

func Test_mergeSort(t *testing.T) {
	a := []int{3, 321, 54, 12, 43, 54, 6455, 123, 534662, 543, 412, 3, 24, 43, 543, 5, 34}
	mergeSort(a, 0, len(a)-1)
	t.Log(a)
}
