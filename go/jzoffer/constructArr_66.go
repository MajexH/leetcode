package jzoffer

func constructArr(a []int) []int {
	if len(a) == 0 {
		return []int{}
	}
	left, right := make([]int, len(a)), make([]int, len(a))

	left[0] = 1
	for i := 1; i < len(a); i++ {
		left[i] = left[i-1] * a[i-1]
	}

	right[len(right)-1] = 1
	for i := len(right) - 2; i >= 0; i-- {
		right[i] = right[i+1] * a[i+1]
	}

	res := make([]int, len(a))

	for i := 0; i < len(a); i++ {
		res[i] = left[i] * right[i]
	}
	return res
}
