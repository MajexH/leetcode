package classic

import "testing"

func Test_maxTurbulenceSize(t *testing.T) {
	t.Log(maxTurbulenceSize([]int{9, 4, 2, 10, 7, 8, 8, 1, 9}))
	t.Log(maxTurbulenceSize([]int{4, 8, 12, 16}))
	t.Log(maxTurbulenceSize([]int{100}))
}
