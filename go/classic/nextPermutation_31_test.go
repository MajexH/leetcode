package classic

import "testing"

func Test_nextPermutation(t *testing.T) {
	a := []int{1, 2, 3}
	nextPermutation(a)
	t.Log(a)
	a = []int{3, 2, 1}
	nextPermutation(a)
	t.Log(a)
	a = []int{1, 1, 5}
	nextPermutation(a)
	t.Log(a)
	a = []int{1}
	nextPermutation(a)
	t.Log(a)
}
