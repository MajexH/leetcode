package classic

import "testing"

func Test_canJump(t *testing.T) {
	t.Log(canJump([]int{2, 3, 1, 1, 4}))
	t.Log(canJump([]int{3, 2, 1, 0, 4}))
}
