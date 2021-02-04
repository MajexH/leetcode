package classic

// rangeBitwiseAnd 由于给定范围很大 因此这儿直接 & 会超时
func rangeBitwiseAnd(m int, n int) int {
	if m == n {
		return m
	}
	// 考虑 [5,6,7] 三个数 & 起来的话 实际上是 考虑 最大值 和 最小值的 左侧相等的部分是多少
	// mov 记录移位了多少次 然后再移动回来
	mov := 0
	for m != n {
		m >>= 1
		n >>= 1
		mov++
	}

	return m << mov
}
