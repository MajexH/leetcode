package classic

import "testing"

func Test_hIndex(t *testing.T) {
	t.Log(hIndex([]int{2, 0, 6, 1, 5}))
}
