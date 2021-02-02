package classic

func maxProduct(nums []int) int {
	if len(nums) == 0 {
		return -1
	}
	mi, ma := nums[0], nums[0]
	res := nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] < 0 {
			tmp := mi
			mi = ma
			ma = tmp
		}
		ma = max(ma*nums[i], nums[i])
		mi = min(mi*nums[i], nums[i])
		res = max(ma, res)
	}

	return res
}
