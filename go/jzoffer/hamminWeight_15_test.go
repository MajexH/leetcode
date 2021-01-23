package jzoffer

import "testing"

func Test_hammingWeight(t *testing.T) {
	t.Log(hammingWeight(3))
	t.Log(hammingWeight(1))
	t.Log(hammingWeight(31))
	t.Log(hammingWeight(9))
}
