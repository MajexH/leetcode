package classic

import "testing"

func Test_rangeBitwiseAnd(t *testing.T) {
	t.Log(rangeBitwiseAnd(5, 7))
	t.Log(rangeBitwiseAnd(0, 1))
	t.Log(rangeBitwiseAnd(3, 11))
	t.Log(rangeBitwiseAnd(0, 0))
}
