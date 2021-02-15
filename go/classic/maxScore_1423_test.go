package classic

import (
	"testing"
)

func Test_maxScore(t *testing.T) {
	t.Log(maxScore([]int{1, 3, 2, 42, 5, 2, 6, 1}, 3))
}
