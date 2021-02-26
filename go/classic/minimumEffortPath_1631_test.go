package classic

import "testing"

func Test_minimumEffortPath(t *testing.T) {
	t.Log(minimumEffortPath([][]int{
		{1,2,2},
		{3,8,2},
		{5,3,5},
	}))
}
