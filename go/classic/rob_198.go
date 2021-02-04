package classic

// rob 找到隔数相加的最大值
// 优化下 内存
func rob(nums []int) int {
	if len(nums) <= 0 {
		return 0
	}
	// 优化的目的在于去掉数组 因为现在直接最大的就是
	notRob, rob := 0, 0
	res := 0

	for _, num := range nums {
		rm := rob
		rob = notRob + num
		notRob = max(notRob, rm)
		res = max(notRob, rob)
	}
	return res
}

// robWithArray 找到隔一个数相加 最后能形成的最大值
// 1. 如果当前这个数拿 说明前一个数不能拿
// 2. 如果当前这个数拿 说明前一个数拿不拿无所谓 因此取前面的最大值
func robWithArray(nums []int) int {
	notRob, rob := make([]int, len(nums)), make([]int, len(nums))
	res := 0
	for i := 0; i < len(nums); i++ {
		if i >= 1 {
			rob[i] = nums[i] + notRob[i-1]
			// 如果不拿当前这个 那么前面一个拿不拿无所谓
			notRob[i] = max(rob[i-1], notRob[i-1])
		} else {
			rob[i] = nums[i]
		}
		res = max(res, max(rob[i], notRob[i]))
	}
	return res
}
