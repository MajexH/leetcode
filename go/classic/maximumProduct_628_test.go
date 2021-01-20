package classic

import (
	"fmt"
	"testing"
)

func Test_maximumProduct(t *testing.T) {
	fmt.Println(maximumProduct([]int{1, 2, 3}))
	fmt.Println(maximumProduct([]int{1, 2, 3, 4}))
	fmt.Println(maximumProduct([]int{4, 5, 1, 2, 3}))
	fmt.Println(maximumProduct([]int{-100, -98, -1, 2, 3, 4}))
	fmt.Println(maximumProduct([]int{-1, -2, -3, -4}))
}
