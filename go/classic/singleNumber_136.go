package classic

// nums 中的每个元素出现了两次
func singleNumber(nums []int) int {
	res := 0

	for _, num := range nums {
		res ^= num
	}
	return res
}

// singleNumberTriple nums 中的 num 出现的次数为3
func singleNumberTriple(nums []int) int {
	var res int32

	for i := 0; i < 32; i++ {
		var count int32
		for _, num := range nums {
			count += (int32(num) >> i) & 1
		}
		res += (count % 3) << i
	}
	return int(res)
}
