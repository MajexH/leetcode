package classic

import (
	"testing"
)

func Test_maxSlidingWindow(t *testing.T) {
	t.Log(maxSlidingWindow([]int{1, 3, -1, -3, 5, 3, 6, 7}, 3))
}
