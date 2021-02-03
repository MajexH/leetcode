package jzoffer

// 或者使用 partition 找到 中间的 mid 也是 o(n)
func majorityElementWithPartition(nums []int) int {
	i, j := 0, len(nums)-1
	mid, index := (i+j)/2, partition(nums, i, j)
	for index != mid {
		if index > mid {
			j = index - 1
		} else {
			i = index + 1
		}
		index = partition(nums, i, j)
	}
	return nums[mid]
}

func partition(nums []int, start, end int) int {
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

// 两两抵消
func majorityElement(nums []int) int {
	if len(nums) == 0 {
		return -1
	}

	num, count := nums[0], 1

	for i := 1; i < len(nums); i++ {
		if num == nums[i] {
			count++
		} else if count > 0 {
			count--
		} else {
			num = nums[i]
			count = 1
		}
	}
	return num
}
