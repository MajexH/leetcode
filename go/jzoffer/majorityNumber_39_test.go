package jzoffer

import "testing"

func Test_majorityElement(t *testing.T) {
	t.Log(majorityElement([]int{6, 5, 5}))
	t.Log(majorityElementWithPartition([]int{1, 2, 3, 2, 2, 2, 5, 4, 2}))
}
