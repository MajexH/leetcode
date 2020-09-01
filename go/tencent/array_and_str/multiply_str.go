package main

import (
	"bytes"
	"fmt"
	"strconv"
)

func main() {
	fmt.Println(multiply("123", "0"))
}

func multiply(num1 string, num2 string) string {
	res := make([]int, len(num1)+len(num2))

	for i := len(num1) - 1; i >= 0; i-- {
		add := 0
		temp1 := int(num1[i] - '0')
		for j := len(num2) - 1; j >= 0; j-- {
			tempSum := add + temp1*int(num2[j]-'0') + res[i+j+1]
			add = tempSum / 10
			res[i+j+1] = tempSum % 10
		}
		if add != 0 {
			res[i] += add
		}
	}

	var buffer bytes.Buffer

	var flag = true

	for _, val := range res {
		if flag && val == 0 {
			continue
		}
		flag = false
		buffer.WriteString(strconv.Itoa(val))
	}
	if buffer.Len() == 0 {
		return "0"
	}
	return buffer.String()
}
