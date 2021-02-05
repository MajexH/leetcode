package classic

import "testing"

func Test_calculate(t *testing.T) {
	t.Log(calculate("3+2*2"))
	t.Log(calculate("3/2"))
	t.Log(calculate("3+5 / 2"))
	t.Log(calculate("1-1+1"))
}
