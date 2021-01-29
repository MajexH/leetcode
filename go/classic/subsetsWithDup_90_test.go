package classic

import (
	"testing"
)

func Test_subsetsWithDup(t *testing.T) {
	t.Log(subsetsWithDup([]int{1, 2, 2}))
	t.Log(subsetsWithDup([]int{4, 4, 4, 1, 4}))
}
