package classic

import "testing"

func Test_rob(t *testing.T) {
	t.Log(rob([]int{1, 2, 3, 1}))
	t.Log(rob([]int{2, 7, 9, 3, 1}))
	t.Log(rob([]int{2, 1, 1, 2}))
}
