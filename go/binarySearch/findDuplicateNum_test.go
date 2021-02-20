package binarySearch

import "testing"

func Test_findDuplicate(t *testing.T) {
	t.Log(findDuplicate([]int{1, 3, 4, 2, 2}))
	t.Log(findDuplicate([]int{3, 1, 3, 4, 2}))
	t.Log(findDuplicate([]int{1, 1}))
	t.Log(findDuplicate([]int{1, 1, 2}))
	t.Log(findDuplicate([]int{2, 2, 2, 2, 2}))
}
