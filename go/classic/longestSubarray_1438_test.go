package classic

import "testing"

func Test_longestSubarray(t *testing.T) {
	t.Log(longestSubarray([]int{8, 2, 4, 7}, 4))
	t.Log(longestSubarray([]int{10, 1, 2, 4, 7, 2}, 5))
	t.Log(longestSubarray([]int{4, 2, 2, 2, 4, 4, 2, 2}, 0))
}
