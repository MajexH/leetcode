package classic

import "testing"

func Test_searchMatrix(t *testing.T) {
	t.Log(searchMatrix([][]int{
		{1},
		{3},
		{5},
	}, 3))
	t.Log(searchMatrix([][]int{
		{1, 3, 5, 7},
		{10, 11, 16, 20},
		{23, 30, 34, 60},
	}, 13))
}
