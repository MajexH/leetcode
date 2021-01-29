package classic

import "testing"

func Test_numDecodings(t *testing.T) {
	t.Log(numDecodings("12"))
	t.Log(numDecodings("226"))
	t.Log(numDecodings("0"))
	t.Log(numDecodings("1"))
}
