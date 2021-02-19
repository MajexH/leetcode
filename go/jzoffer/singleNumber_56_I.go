package jzoffer

// nums 中除了两个数字出现一次 其余均出现两次 找到这个数字
func singleNumbers(nums []int) []int {
	res := 0
	for _, num := range nums {
		res ^= num
	}
	// 因为有两个数不等 那么 res 一定不为0 即 二进制中有一位 为 1
	// 找到 res 某一个位是否为 1 根据这个位数分离
	counter := 0
	for res&1 == 0 {
		counter++
		res >>= 1
	}

	num1, num2 := 0, 0

	for _, num := range nums {
		if num>>counter&1 == 1 {
			num1 ^= num
		} else {
			num2 ^= num
		}
	}
	return []int{num1, num2}
}
