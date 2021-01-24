package classic

import (
	"testing"
)

func Test_combinationSum2(t *testing.T) {
	t.Log(combinationSum2([]int{10, 1, 2, 7, 6, 1, 5}, 8))
	t.Log(combinationSum2([]int{2, 5, 2, 1, 2}, 5))
}
