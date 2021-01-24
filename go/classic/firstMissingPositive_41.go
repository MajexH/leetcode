package classic

import (
	"math"
	"sort"
)

func firstMissingPositive(nums []int) int {
	memo := make(map[int]int)

	for _, num := range nums {
		memo[num] = 1
	}

	for i := 1; i < math.MaxInt32; i++ {
		if _, ok := memo[i]; !ok {
			return i
		}
	}
	return -1
}

func firstMissingPositive1(nums []int) int {
	sort.Ints(nums)
	positive, flag := 0, false
	for _, num := range nums {
		if num > 0 {
			flag = true
			// 因为存在连续的相同数字 因此这儿需要判断两种情况
			// 1 是相同的数字 就不需要在变化了
			// 2 是可能是 +1 的下一个正整数
			if positive != num && positive+1 != num {
				return positive + 1
			}
		}
		if flag {
			positive = num
		}
	}
	return positive + 1
}
