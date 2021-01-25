package classic

// jump 不是判断是否可以跳到最后一个
// 而是在能调到最后一个的情况下 找到最少的跳跃次数
func jump(nums []int) int {
	if len(nums) == 1 {
		return 1
	}
	// 上一道题可以使用贪心做
	rightMost := 0
	// 当每次到达 最远的距离的时候 说明要从现在这个位置再跳一次
	// end 是上一个 rightmost 最远达到的距离
	step, end := 0, 0
	for i, num := range nums {
		rightMost = max(rightMost, i+num)
		if rightMost >= len(nums)-1 {
			// 说明再跳已经可以到结尾了
			return step + 1
		}
		// 这个可以的原因在于
		// 因为一定可以到达最后一个点
		// 所以他最少跳的次数 一定是在上一个到达了最远距离的时候再跳的次数
		if end == i {
			step++
			end = rightMost
		}
	}
	return step
}
