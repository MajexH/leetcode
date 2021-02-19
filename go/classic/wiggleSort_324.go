package classic

import "sort"

func wiggleSort(nums []int) {
	// 采用 partition 的话
	// 只有 o(n)
	start, end := 0, len(nums)-1
	mid := (start + end) / 2
	index := partitionWiggleSort(nums, start, end)
	for index != mid {
		if index > mid {
			end = index - 1
		} else {
			start = index + 1
		}
		index = partitionWiggleSort(nums, start, end)
	}
	tmp := make([]int, len(nums))
	// 拍完一半的序 因为有可能回存在 mid 对应的数 有多个相等的情况
	// 因此 直接插乱排入的话 可能会把相等的数排在一起
	// 为了避免这种情况 重新遍历 nums 把跟 mid 相等的 分别排在数组的 最左和最右
	odd := 1
	var even int
	if len(nums)%2 == 1 {
		even = len(nums) - 1
	} else {
		even = len(nums) - 2
	}
	for _, num := range nums {
		if num > nums[mid] {
			tmp[odd] = num
			odd += 2
		} else if num < nums[mid] {
			tmp[even] = num
			even -= 2
		}
	}
	// 剩下还有 nums[mid] 填充
	for odd < len(nums) {
		tmp[odd] = nums[mid]
		odd += 2
	}
	for even >= 0 {
		tmp[even] = nums[mid]
		even -= 2
	}
	copy(nums, tmp)
}

func wiggleSortWithSort(nums []int) {
	sort.Ints(nums)
	tmp := make([]int, len(nums))
	// 拍完一半的序
	i, j := (len(nums)-1)/2, len(nums)-1
	count := 0
	for i >= 0 {
		tmp[count] = nums[i]
		count++
		i--
		if count >= len(tmp) {
			break
		}
		tmp[count] = nums[j]
		count++
		j--
	}

	copy(nums, tmp)
}

func partitionWiggleSort(nums []int, start, end int) int {
	base := nums[start]
	i, j := start, end+1

	for true {
		i++
		for i <= end && nums[i] < base {
			i++
		}
		j--
		for j >= start && nums[j] > base {
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
