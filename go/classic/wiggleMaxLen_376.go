package classic

// 两个数组分别代表上升和下降序列的最大长度
// 因为 wiggle 的数组 是一升一降 的 up[i] 表示 最后一个 nums[i] 是上升的趋势的最大值
func wiggleMaxLength(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	up, down := 1, 1

	for i := 1; i < len(nums); i++ {
		preDown, PreUp := down, up
		if nums[i] > nums[i-1] {
			up = max(down+1, up)
			down = preDown
		} else if nums[i] < nums[i-1] {
			down = max(up+1, down)
			up = PreUp
		} else {
			up = PreUp
			down = preDown
		}
	}
	return max(up, down)
}

// 两个数组分别代表上升和下降序列的最大长度
// 因为 wiggle 的数组 是一升一降 的 up[i] 表示 最后一个 nums[i] 是上升的趋势的最大值
func wiggleMaxLengthWithoutMemo(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	// up[i] down[i] 分别代表上升和下降序列(最后一个是上升或者下降)的 在 index = i 时的最长长度
	ups, downs := make([]int, len(nums)), make([]int, len(nums))
	// 初始化
	ups[0] = 1
	downs[0] = 1
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			// 如果 nums i 是上升趋势 说明那么 之前前一个是下降的趋势的话 可以 加一
			// 同时 也可以不考虑这个 上升趋势 跟前一个比较
			ups[i] = max(downs[i-1]+1, ups[i-1])
			// 此时由于是上升的 所以没有下降的趋势 状态直接转移
			downs[i] = downs[i-1]
		} else if nums[i] < nums[i-1] {
			downs[i] = max(ups[i-1]+1, downs[i-1])
			ups[i] = ups[i-1]
		} else {
			// 相等的情况下是不变的
			ups[i] = ups[i-1]
			downs[i] = downs[i-1]
		}
	}
	return max(ups[len(ups)-1], downs[len(downs)-1])
}
