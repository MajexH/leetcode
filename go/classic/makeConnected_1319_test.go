package classic

import "testing"

func Test_makeConnected(t *testing.T) {
	t.Log(makeConnected(4, [][]int{{0, 1}, {0, 2}, {1, 2}}))
	t.Log(makeConnected(6, [][]int{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}))
	t.Log(makeConnected(6, [][]int{{0, 1}, {0, 2}, {0, 3}, {1, 2}}))
	t.Log(makeConnected(5, [][]int{{0, 1}, {0, 2}, {3, 4}, {2, 3}}))
	t.Log(makeConnected(11, [][]int{{1, 4}, {0, 3}, {1, 3}, {3, 7}, {2, 7}, {0, 1}, {2, 4}, {3, 6}, {5, 6}, {6, 7}, {4, 7}, {0, 7}, {5, 7}}))
}
