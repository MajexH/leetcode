package classic

// 找到 A 中连续的子数组 里面的 distinct 的数字为 K 个
// 滑动窗口 (直接找到 等于 K 的其实是不好找的)
// 因为去滑动的时候 判断 == K 的条件 复杂 而且不好把控
func subarraysWithKDistinct(A []int, K int) int {
	return atMostK(A, K) - atMostK(A, K-1)
}

// 因为求解 恰好K 不好弄 求解 最大K 比较好弄
func atMostK(A []int, K int) int {
	i, j := 0, 0
	// 作为一个 set 保存窗口内的所有 distinct 数据
	window := make(map[int]int)
	res := 0

	for j < len(A) {
		window[A[j]]++
		j++

		for len(window) > K {
			window[A[i]]--
			if window[A[i]] == 0 {
				delete(window, A[i])
			}
			i++
		}

		res += j - i + 1
	}

	return res
}
