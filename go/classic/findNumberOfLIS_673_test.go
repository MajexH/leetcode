package classic

import "testing"

func Test_findNumberOfLIS(t *testing.T) {
	t.Log(findNumberOfLIS([]int{1, 3, 5, 4, 7}))
	t.Log(findNumberOfLIS([]int{1, 2, 4, 3, 5, 4, 7, 2}))
}
