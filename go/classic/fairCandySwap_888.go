package classic

// fairCandySwap 数学原理 首先找到两个数组之间和的差值
// 就可以找到两个要交换的数之间的差值，然后随便找到一组交换即可
func fairCandySwap(A []int, B []int) []int {
	mapForB := make(map[int]int)

	sumA, sumB := getSum(A), getSum(B)
	for _, num := range B {
		mapForB[num] = 1
	}

	diff := (sumA - sumB) / 2

	for _, num := range A {
		if _, ok := mapForB[num-diff]; ok {
			return []int{num, num - diff}
		}
	}
	return []int{}
}
