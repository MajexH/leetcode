package sort

// 合并两个排序数组
func mergeTwoArray(A []int, m int, B []int, n int) {
	i, j := 0, 0
	index := 0
	tmp := make([]int, len(A))
	copy(tmp, A)
	for i < m && j < n {
		if A[i] < B[j] {
			tmp[index] = A[i]
			i++
		} else {
			tmp[index] = B[j]
			j++
		}
		index++
	}
	for i < m {
		tmp[index] = A[i]
		i++
		index++
	}
	for j < n {
		tmp[index] = B[j]
		j++
		index++
	}

	for i, num := range tmp {
		A[i] = num
	}
}
