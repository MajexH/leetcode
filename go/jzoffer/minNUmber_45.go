package jzoffer

import (
	"sort"
	"strconv"
	"strings"
)

func minNumber(nums []int) string {
	strs := make([]string, len(nums))

	for i, num := range nums {
		strs[i] = strconv.Itoa(num)
	}

	sort.Slice(strs, func(i, j int) bool {
		return strs[i]+strs[j] <= strs[j]+strs[i]
	})

	return strings.Join(strs, "")
}
