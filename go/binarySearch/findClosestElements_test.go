package binarySearch

import (
	"testing"
)

func Test_findClosestElements(t *testing.T) {
	t.Log(findClosestElements([]int{1, 2, 3, 4, 5}, 4, 3))
	t.Log(findClosestElements([]int{1, 2, 3, 4, 5}, 4, -1))
	t.Log(findClosestElements([]int{1, 1, 1, 10, 10, 10}, 1, 9))
	t.Log(findClosestElements([]int{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4))
}
