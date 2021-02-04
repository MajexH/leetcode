package classic

// robCircular rob 的是一个循环数组 也就是说首尾相连
// 那么 rob 的时候 如果 rob 第一个房间 就不能 rob 最后一个房间
// 因此分为两个部分
// 1. rob 从 0 -> len - 2
// 2. rob 从 1 -> len - 1
// 然后比较大小即可
func robCircular(nums []int) int {
	if len(nums) <= 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	// 因为是首尾相连的
	robFirst := getMaxRob(nums[:len(nums)-1])
	notRobFirst := getMaxRob(nums[1:])
	return max(robFirst, notRobFirst)
}

func getMaxRob(nums []int) int {
	notRob, rob := 0, 0
	res := 0

	for _, num := range nums {
		rem := rob
		rob = notRob + num
		notRob = max(rem, notRob)
		res = max(res, max(rob, notRob))
	}
	return res
}
