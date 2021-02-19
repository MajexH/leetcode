package classic

import (
	"testing"
)

func Test_findOrder(t *testing.T) {
	t.Log(findOrder(2, [][]int{{1, 0}}))
	t.Log(findOrder(4, [][]int{{1, 0}, {2, 0}, {3, 1}, {3, 2}}))
}
