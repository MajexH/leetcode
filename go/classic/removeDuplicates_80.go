package classic

func removeDuplicates(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}
	// i, j 代表一对相对的区间的开始和结尾的index
	// j 指向了下一个不等于的地方
	i, j := 0, 0
	// 更新的位置
	counter := 0
	for j < len(nums) {
		for j < len(nums) && nums[j] == nums[i] {
			j++
		}
		// 赋值一片
		for z := 0; z < min(2, j-i); z++ {
			nums[counter] = nums[i]
			counter++
		}
		i = j
	}
	return counter
}
