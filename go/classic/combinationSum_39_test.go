package classic

import (
	"testing"
)

func Test_combinationSum(t *testing.T) {
	t.Log(combinationSum([]int{2, 3, 6, 7}, 7))
	t.Log(combinationSum([]int{2, 3, 5}, 8))
}
