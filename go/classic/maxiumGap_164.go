package classic

import (
	"math"
	"sort"
)

// 基数排序 根据 10 进制的位数 每次排序 一个位置上的 数字 然后直到拍完位置
func maximumGap(nums []int) int {
	if len(nums) < 2 {
		return 0
	}

	biggest := nums[0]
	for _, num := range nums {
		biggest = max(biggest, num)
	}

	// 基数排序的桶 分为 0 - 9
	lists := make([][]int, 10)

	base := 1
	for biggest > 0 {
		// 每次循环前都重置
		for i := 0; i < 10; i++ {
			lists[i] = make([]int, 0)
		}
		// 排序数组
		for _, num := range nums {
			i := num / base % 10
			lists[i] = append(lists[i], num)
		}

		// 根据每轮的顺序 重新赋值 nums 数组
		for i, index := 0, 0; i < 10; i++ {
			for j := 0; j < len(lists[i]); j++ {
				nums[index] = lists[i][j]
				index++
			}
		}

		biggest /= 10
		base *= 10
	}

	res := 0

	for i := 0; i < len(nums)-1; i++ {
		res = max(res, nums[i+1]-nums[i])
	}
	return res
}

// 使用桶排序 会超出内存限制
func maximumGapWithBucket(nums []int) int {
	if len(nums) < 2 {
		return 0
	}

	smallest, biggest := math.MaxInt32, math.MinInt32

	for _, num := range nums {
		smallest = min(smallest, num)
		biggest = max(biggest, num)
	}

	// 桶排序
	counts := make([]int, biggest-smallest+1)

	for _, num := range nums {
		counts[num-smallest]++
	}
	res := 0
	var pre *int

	for i, num := range counts {
		// 表示没有数字
		if num == 0 {
			continue
		}
		if pre == nil {
			tmp := i
			pre = &tmp
			continue
		}
		// 比较
		res = max(res, i-*pre)
		tmp := i
		pre = &tmp
	}
	return res
}

// 题目要求的是 常数空间和时间的对比
func maximumGapWithoutOn(nums []int) int {
	sort.Ints(nums)
	res := 0

	for i := 0; i < len(nums)-1; i++ {
		res = max(res, nums[i+1]-nums[i])
	}
	return res
}
