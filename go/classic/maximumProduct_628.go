package classic

// maximumProduct 找到最大的三个数相乘的结果
// 这个就是个排序 找到最大的三个数相乘的结果
// 由于排序算法最好是 o(nlogn) 所以考虑使用 quick sort 的 split 来做
// 下面这种做法是没有负数的情况 有负数的话 就要考虑 2 个负数的乘积可能会比较大
func maximumProductWithOutMinus(nums []int) int {
	if len(nums) < 3 {
		return 0
	}
	return findNthMax(nums, 0) * findNthMax(nums, 1) * findNthMax(nums, 2)
}

// 有负数的情况就取最小的两个负数乘积 * 最大的一个整数
// 1. 如果数组全是正数 取最大的三个
// 2. 如果数组中存在最大的是正数，则看最小的两个是否同时是负数，是则乘起来，否则选最大的三个
// 3. 如果全是负数，则取最大的三个负数
func maximumProduct(nums []int) int {
	maxNumber := findNthMax(nums, 0)
	if maxNumber > 0 {
		// 选择两种结果中较大的
		return maxNumber *
			max(findNthMax(nums, 1)*findNthMax(nums, 2),
				findNthMax(nums, len(nums)-1)*findNthMax(nums, len(nums)-2))
	} else { // 现在 maxNumber <= 0 所以所有的都是小于等于 0 的
		return maxNumber * findNthMax(nums, 1) * findNthMax(nums, 2)
	}
}

func findNthMax(nums []int, n int) int {
	i, j := 0, len(nums)-1
	index := partition(nums, i, j)
	for index != n {
		if index > n {
			j = index - 1
		} else {
			i = index + 1
		}
		index = partition(nums, i, j)
	}
	return nums[n]
}

// partition 快排的重要一步 分离
func partition(nums []int, start, end int) int {
	i, j := start, end+1
	// 作为 base 比较的
	base := nums[i]
	for {
		i++
		for i < len(nums) && nums[i] > base {
			i++
		}

		j--
		for j >= 0 && nums[j] < base {
			j--
		}
		if i >= j {
			break
		}
		swap(nums, i, j)
	}
	swap(nums, start, j)
	return j
}

// 数值相等不能这样交换
func swap(nums []int, i, j int) {
	if nums[i] == nums[j] {
		return
	}
	nums[i] = nums[i] ^ nums[j]
	nums[j] = nums[i] ^ nums[j]
	nums[i] = nums[i] ^ nums[j]
}
