package classic

func reverse(nums []int, i, j int) {
	for i < j {
		swap(nums, i, j)
		i++
		j--
	}
}

func nextPermutation(nums []int) {
	if nums == nil || len(nums) == 0 {
		return
	}

	i := len(nums) - 1
	// 找到第一个逆序的数对 然后交换
	for i >= 1 && nums[i] <= nums[i-1] {
		i--
	}
	// 整体逆序
	if i == 0 {
		reverse(nums, 0, len(nums)-1)
		return
	}
	// 出现了逆序数对 说明是中间的某个排列
	// 这个时候需要找到 后面的数据中第一个大于这个逆序中小的那个数
	// 交换后 reverse [i:] 的数组即可
	// 因为后面的整个都是逆序的 所以 下一个排列一定是选取其中的一个比现在 i- 1 位置稍大的数
	// 作为下个排列的开头 然后 后面的数据 按照自然顺序排好
	j := len(nums) - 1
	for ; j >= i; j-- {
		if nums[j] > nums[i-1] {
			break
		}
	}
	swap(nums, j, i-1)
	// 因为交换过去不会改变原来的后面的数据的逆序状态 所以直接反转即可
	reverse(nums, i, len(nums)-1)
}
