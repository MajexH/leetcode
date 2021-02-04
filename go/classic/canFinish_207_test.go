package classic

import "testing"

func Test_canFinish(t *testing.T) {
	t.Log(canFinish(3, [][]int{{1, 0}, {2, 0}, {0, 2}}))
}
