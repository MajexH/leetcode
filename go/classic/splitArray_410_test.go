package classic

import "testing"

func Test_splitArray(t *testing.T) {
	t.Log(splitArray([]int{7, 2, 5, 10, 8}, 2))
	t.Log(splitArray([]int{1, 2, 3, 4, 5}, 2))
	t.Log(splitArray([]int{1, 4, 4}, 3))
	t.Log(splitArray([]int{2, 16, 14, 15}, 2))
}
