package classic

// 超时 其实可以维护一个滑动窗口 如果其中的 最大 或者 最小值 相距 t 即可
func containsNearbyAlmostDuplicate(nums []int, k int, t int) bool {
	// 要能够在对数时间内找到 最大最小值 只能是 平衡二叉树
	return false
}

// 超时
func containsNearbyAlmostDuplicateForce(nums []int, k int, t int) bool {
	if k < 0 || t < 0 {
		return false
	}

	for i, num := range nums {
		for j := max(0, i-k); j <= min(len(nums)-1, i+k); j++ {
			if j == i {
				continue
			}

			if num >= nums[j] && num-nums[j] <= t {
				return true
			}
			if num <= nums[j] && nums[j]-num <= t {
				return true
			}
		}
	}
	return false
}
