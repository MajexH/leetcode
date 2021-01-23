package jzoffer

import "testing"

func Test_myPow(t *testing.T) {
	t.Log(myPow(2, 10))
	t.Log(myPow(0.00001, 2147483647))
}
