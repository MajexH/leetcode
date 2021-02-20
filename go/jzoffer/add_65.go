package jzoffer

func add(a int, b int) int {
	// b 作为进位的数
	for b != 0 {
		// 得到二进制中每位留下的数
		// 1 ^ 0 = 1 所以这是每位留下的
		tmp := a ^ b
		// 1 & 1 = 1 所以这是进位的数
		b = (a & b) << 1
		// 加起来
		a = tmp
	}

	return a
}
