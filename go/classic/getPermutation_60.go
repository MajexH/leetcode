package classic

import "strconv"

// [1-4] 进行排列 找到第K个排列
func getPermutation(n int, k int) string {
	nums := make([]int, n)
	fac := make([]int, n)
	memo := make([]bool, n)

	fac[0] = 1
	for i := 1; i < n; i++ {
		fac[i] = fac[i-1] * i
	}

	for i := 0; i < n; i++ {
		nums[i] = i + 1
	}

	return recursionGetPermutation(&fac, &nums, n, k, &memo)
}

// recursionGetPermutation
// fac 阶乘函数的值 k 第几个排列 used 用来跳过已经完成的排列
func recursionGetPermutation(fac *[]int, nums *[]int, n, k int, used *[]bool) string {
	if n == 0 {
		return ""
	}
	num := 0
	base := (*fac)[n-1]
	// 找到数字
	for i := 0; i < len(*nums); i++ {
		if (*used)[i] {
			continue
		}
		if k > base {
			k -= base
		} else {
			(*used)[i] = true
			num = (*nums)[i]
			break
		}
	}

	return strconv.Itoa(num) + recursionGetPermutation(fac, nums, n-1, k, used)
}
