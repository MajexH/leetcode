package classic

import "testing"

func Test_maxSumAfterPartitioning(t *testing.T) {
	t.Log(maxSumAfterPartitioning([]int{1, 15, 7, 9, 2, 5, 10}, 3))
	t.Log(maxSumAfterPartitioning([]int{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4))
	t.Log(maxSumAfterPartitioning([]int{1}, 1))
}
