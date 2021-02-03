package classic

import (
	"bytes"
	"sort"
	"strconv"
)

func largestNumber(nums []int) string {
	numStrs := make([]string, len(nums))
	for i := 0; i < len(nums); i++ {
		numStrs[i] = strconv.Itoa(nums[i])
	}
	sort.Slice(numStrs, func(i, j int) bool {
		return numStrs[i]+numStrs[j] >= numStrs[j]+numStrs[i]
	})
	res := bytes.Buffer{}
	for _, num := range numStrs {
		res.WriteString(num)
	}
	str := res.String()
	if str[0] == '0' {
		return "0"
	}
	return str
}
