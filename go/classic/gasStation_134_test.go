package classic

import "testing"

func Test_canCompleteCircuit(t *testing.T) {
	t.Log(canCompleteCircuit([]int{1, 2, 3, 4, 5}, []int{3, 4, 5, 1, 2}))
	t.Log(canCompleteCircuit([]int{2, 3, 4}, []int{3, 4, 3}))
}
