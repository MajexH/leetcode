package binarySearch

// 两个的交集 但是里面出现的数字的数量与较小的一个相等
func intersect(nums1 []int, nums2 []int) []int {
	res := make([]int, 0)
	set := make(map[int]int)
	set2 := make(map[int]int)
	for _, num := range nums1 {
		set[num]++
	}
	for _, num := range nums2 {
		set2[num]++
	}

	for num, freq := range set {
		if freq1, ok := set2[num]; ok {
			for i := 0; i < min(freq, freq1); i++ {
				res = append(res, num)
			}

		}
	}
	return res
}
