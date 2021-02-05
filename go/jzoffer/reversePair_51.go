package jzoffer

func reversePairs(nums []int) int {
	return mergeSortFindReversePairs(nums, 0, len(nums)-1)
}

func mergeSortFindReversePairs(nums []int, start, end int) int {
	if start >= end {
		return 0
	}
	mid := (start + end) / 2
	left, right := mergeSortFindReversePairs(nums, start, mid), mergeSortFindReversePairs(nums, mid+1, end)
	return left + right + mergeList(nums, start, mid, end)
}

func mergeList(nums []int, start, mid, end int) int {
	i, j := start, mid+1
	res := 0
	tmp := make([]int, end-start+1)
	count := 0
	for i <= mid && j <= end {
		if nums[i] <= nums[j] {
			tmp[count] = nums[i]
			i++
			// 逆序的
			// 因为 i j 先比较 相当于 j 之前进去的数字都比 现在这个 i 对应的数字小
			res += j - mid - 1
		} else {
			tmp[count] = nums[j]
			j++
		}
		count++
	}
	for i <= mid {
		tmp[count] = nums[i]
		i++
		count++
		// 逆序的 同上
		res += j - mid - 1
	}
	for j <= end {
		tmp[count] = nums[j]
		j++
		count++
	}
	count = 0
	for start <= end {
		nums[start] = tmp[count]
		count++
		start++
	}

	return res
}
