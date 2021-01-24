package classic

import "testing"

func Test_firstMissingPositive(t *testing.T) {
	t.Log(firstMissingPositive([]int{1, 2, 0}))
	t.Log(firstMissingPositive([]int{3, 4, -1, 1}))
	t.Log(firstMissingPositive([]int{7, 8, 9, 11, 12}))
	t.Log(firstMissingPositive([]int{0, 2, 2, 1, 1}))
}
