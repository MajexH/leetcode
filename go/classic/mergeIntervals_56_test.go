package classic

import (
	"testing"
)

func Test_merge(t *testing.T) {
	t.Log(merge([][]int{{0, 0}, {1, 4}}))
}
