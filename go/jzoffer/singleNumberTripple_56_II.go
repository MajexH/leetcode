package jzoffer

// nums 中有一个数字出现1次 其余出现三次
func singleNumber(nums []int) int {
	res := 0
	// 其实就是统计 num 中每一位有多少 然后 % 3
	for i := 31; i >= 0; i-- {
		counter := 0
		for _, num := range nums {
			counter += (num >> i) & 1
		}
		res <<= 1
		res += counter % 3
	}
	return res
}
