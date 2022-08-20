package classic

func intersection(nums1 []int, nums2 []int) []int {
	memo := make(map[int]int)

	for _, num := range nums1 {
		memo[num] = 1
	}

	map4nums2 := make(map[int]int)

	for _, num := range nums2 {
		if _, ok := memo[num]; ok {
			map4nums2[num] = 1
		}
	}

	res := make([]int, 0)

	for key, _ := range map4nums2 {
		res = append(res, key)
	}
	return res
}
