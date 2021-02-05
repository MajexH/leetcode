package classic

// 有两个出现一次的 其余出现两次
func singleNumberIII(nums []int) []int {
	sum := 0

	for _, num := range nums {
		sum ^= num
	}

	// 根据 sum 的某一个不为 0 的位数来
	counter := 1
	for sum&1 == 0 {
		sum >>= 1
		counter <<= 1
	}

	// 找到了这个位数 根据 位数 分成两组即可
	num1, num2 := 0, 0

	for _, num := range nums {
		if num&counter == 0 {
			num1 ^= num
		} else {
			num2 ^= num
		}
	}
	return []int{num1, num2}
}
