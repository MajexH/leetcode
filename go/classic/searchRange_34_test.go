package classic

import (
	"testing"
)

func Test_searchRange(t *testing.T) {
	t.Log(searchRange([]int{5, 7, 7, 8, 8, 10}, 8))
	t.Log(searchRange([]int{5, 7, 7, 8, 8, 10}, 6))
	t.Log(searchRange([]int{}, 8))
}
