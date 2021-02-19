package classic

import "testing"

func Test_maxEnvelopes(t *testing.T) {
	t.Log(maxEnvelopes([][]int{
		{5, 4}, {6, 4}, {6, 7}, {2, 3},
	}))
}
