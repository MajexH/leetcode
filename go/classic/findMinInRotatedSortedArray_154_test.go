package classic

import "testing"

func Test_findMin(t *testing.T) {
	t.Log(findMin([]int{1, 3, 5}))
	t.Log(findMin([]int{2, 2, 2, 0, 1}))
}
