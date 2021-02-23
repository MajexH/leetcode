package leetcodeExplore

import "testing"

func Test_merge(t *testing.T) {
	a := []int{1}
	merge(a, 1, []int{}, 0)
	t.Log(a)
}
