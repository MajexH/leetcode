package classic

func longestOnes(A []int, K int) int {
	// 返回值
	res := 0
	left, right := 0, 0
	zeros := 0
	for right < len(A) {
		// 用外层循环带动 right 移动
		if A[right] == 0 {
			zeros++
		}
		// 这个时候要移动左侧的 left 保障 zeros 小
		for zeros > K {
			if A[left] == 0 {
				zeros--
			}
			left++
		}
		// 每轮都去比较即可
		res = max(res, right-left+1)
		right++
	}
	return res
}

// A 中只有 0 1 其中可以最多把 K 个 0 换成 1
// 最后能够形成的最长的连续 1 的长度为多少
func longestOnesWithMoreFor(A []int, K int) int {
	// 这道题就是看一个窗口内 做多只有 K 个 0 的情况下 能够达到的最大长度

	res := 0
	left, right := -1, -1
	numberOfZero := 0

	for right < len(A) {
		for numberOfZero <= K {
			right++
			if right >= len(A) {
				break
			}
			if A[right] == 0 {
				numberOfZero++
			}
		}

		res = max(res, right-left-1)

		for numberOfZero > K {
			left++
			if left >= len(A) {
				break
			}
			if A[left] == 0 {
				numberOfZero--
			}
		}
	}
	return res
}
