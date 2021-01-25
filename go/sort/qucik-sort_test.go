package sort

import "testing"

func TestQuickSort(t *testing.T) {
	a := []int{321, 54, 12, 654, 21, 321, 56543, 34, 3213, 54, 35, 4, 45123, 4331245, 45324, 432, 65, 56, 5}
	QuickSort(a, 0, len(a)-1)
	t.Log(a)
}
