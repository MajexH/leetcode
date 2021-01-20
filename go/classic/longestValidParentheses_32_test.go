package classic

import (
	"fmt"
	"testing"
)

func Test_longestValidParentheses(t *testing.T) {
	fmt.Println(longestValidParentheses("(()"))
	fmt.Println(longestValidParentheses(")()())"))
	fmt.Println(longestValidParentheses("()()"))
	fmt.Println(longestValidParentheses("(()))"))
	fmt.Println(longestValidParentheses(""))
}
