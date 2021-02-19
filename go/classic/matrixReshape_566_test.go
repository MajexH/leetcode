package classic

import (
	"testing"
)

func Test_matrixReshape(t *testing.T) {
	t.Log(matrixReshape([][]int{{1, 2}, {3, 4}}, 2, 4))
}
