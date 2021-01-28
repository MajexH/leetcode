package classic

func sortColors(nums []int) {
	array := make([]int, 3)

	for _, num := range nums {
		array[num]++
	}

	i, num := 0, 0
	for _, count := range array {
		for j := 0; j < count; j++ {
			nums[i] = num
			i++
		}
		num++
	}
}
