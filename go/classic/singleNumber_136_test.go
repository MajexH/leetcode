package classic

import "testing"

func Test_singleNumberTriple(t *testing.T) {
	t.Log(singleNumberTriple([]int{2, 2, 3, 2}))
	t.Log(singleNumberTriple([]int{0, 1, 0, 1, 0, 1, 99}))
	t.Log(singleNumberTriple([]int{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2}))
}
