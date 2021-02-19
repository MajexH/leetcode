package classic

import "testing"

func Test_containsNearbyAlmostDuplicate(t *testing.T) {
	t.Log(containsNearbyAlmostDuplicate([]int{1, 2, 3, 1}, 3, 0))
	t.Log(containsNearbyAlmostDuplicate([]int{1, 5, 9, 1, 5, 9}, 2, 3))
}
