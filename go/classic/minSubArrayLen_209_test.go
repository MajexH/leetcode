package classic

import "testing"

func Test_minSubArrayLen(t *testing.T) {
	t.Log(minSubArrayLen(7, []int{2, 3, 1, 2, 4, 3}))
	t.Log(minSubArrayLen(11, []int{1, 2, 3, 4, 5}))
}
