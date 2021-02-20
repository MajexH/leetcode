package classic

import "testing"

func Test_findShortestSubArray(t *testing.T) {
	t.Log(findShortestSubArray([]int{1, 2, 2, 3, 1}))
	t.Log(findShortestSubArray([]int{1, 2, 2, 3, 1, 4, 2}))
}
