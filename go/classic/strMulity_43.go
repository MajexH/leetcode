package classic

import (
	"fmt"
	"strings"
)

func multiply(num1 string, num2 string) string {
	if len(num1) == 0 || len(num2) == 0 || num1 == "0" || num2 == "0" {
		return "0"
	}

	res := make([]int, len(num1)+len(num2))

	for i := len(num1) - 1; i >= 0; i-- {
		add := 0
		n1 := int(num1[i] - '0')
		for j := len(num2) - 1; j >= 0; j-- {
			tmp := n1*int(num2[j]-'0') + add + res[i+j+1]
			add = tmp / 10
			res[i+j+1] = tmp % 10
		}
		if add != 0 {
			res[i] = add
		}
	}

	builder := strings.Builder{}
	flag := false

	for _, num := range res {
		if num != 0 {
			flag = true
		}
		if flag {
			builder.WriteString(fmt.Sprint(num))
		}
	}

	return builder.String()
}
