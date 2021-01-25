package sort

func mergeSort(nums []int, i, j int) {
	if i >= j {
		return
	}
	mid := (i + j) / 2
	mergeSort(nums, i, mid)
	mergeSort(nums, mid+1, j)
	// 这一步 i -> mid mid + 1 -> j 已经是有序的了
	merge(nums, i, mid, j)
}

func merge(nums []int, i, mid, j int) {
	tmp, index := make([]int, j-i+1), 0
	iStart, jStart := i, mid+1
	for iStart <= mid && jStart <= j {
		if nums[iStart] > nums[jStart] {
			tmp[index] = nums[jStart]
			jStart++
		} else {
			tmp[index] = nums[iStart]
			iStart++
		}
		index++
	}

	for iStart <= mid {
		tmp[index] = nums[iStart]
		index++
		iStart++
	}

	for jStart <= j {
		tmp[index] = nums[jStart]
		index++
		jStart++
	}

	for m, n := 0, i; m < len(tmp); m, n = m+1, n+1 {
		nums[n] = tmp[m]
	}
}
