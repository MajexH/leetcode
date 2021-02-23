package jzoffer

func lastRemaining(n int, m int) int {
	last := 0

	for i := 2; i <= n; i++ {
		last = (last + m) % i
	}
	return last
}

// 超时了
func lastRemainingWithSimulation(n int, m int) int {
	list := make([]int, n)
	// 构建需要移除的数组
	for i := 0; i < n; i++ {
		list[i] = i
	}
	// 每次移除的 idx
	idx := 0
	for n > 1 {
		// 这次移除的数字的位置 是上次的 idx + m - 1 % n (%n 是循环的原因)
		idx = (idx + m - 1) % n
		list = append(list[:idx], list[idx+1:]...)
		// 循环完之后 会少一个数
		n--
	}
	return list[0]
}
