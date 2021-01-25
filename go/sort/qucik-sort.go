package sort

func QuickSort(nums []int, i, j int) {
	if i >= j {
		return
	}
	p := partition(nums, i, j)
	QuickSort(nums, i, p-1)
	QuickSort(nums, p+1, j)
}

func partition(nums []int, start, end int) int {
	base := nums[start]

	i, j := start, end+1

	for true {
		i++
		for i < len(nums) && nums[i] < base {
			i++
		}

		j--
		for j >= 0 && nums[j] > base {
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

func swap(nums []int, i, j int) {
	if nums[i] == nums[j] {
		return
	}
	nums[i] = nums[i] ^ nums[j]
	nums[j] = nums[i] ^ nums[j]
	nums[i] = nums[i] ^ nums[j]
}
