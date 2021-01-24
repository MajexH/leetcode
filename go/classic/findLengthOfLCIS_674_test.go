package classic

import "testing"

func Test_findLengthOfLCIS(t *testing.T) {
	t.Log(findLengthOfLCIS([]int{1, 3, 5, 4, 7}))
	t.Log(findLengthOfLCIS([]int{2, 2, 2, 2}))
	t.Log(findLengthOfLCIS([]int{1, 3, 5, 7}))
}
