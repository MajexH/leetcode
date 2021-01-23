package jzoffer

func hammingWeight1(num uint32) int {
	res := 0
	var tmp uint32 = 1
	for tmp != 0 {
		if num&tmp != 0 {
			res++
		}
		tmp <<= 1
	}
	return res
}

// n&(n-1) 可以将n最右边的一个 1 清零
func hammingWeight(num uint32) int {
	res := 0
	for num != 0 {
		num &= num - 1
		res++
	}
	return res
}
