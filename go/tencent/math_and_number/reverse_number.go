package main

import "fmt"

func main() {
	fmt.Println(reverse(123))
	fmt.Println(reverse(-123))
	fmt.Println(reverse(120))
	fmt.Println(reverse(int(INT_MAX)))
}

const INT_MIN = ^INT_MAX
const INT_MAX = int32(^uint32(0) >> 1)

func reverse(y int) int {
	x := int32(y)
	var res int32 = 0
	for x != 0 {
		add := x % 10
		if res > INT_MAX/10 || (res == INT_MAX/10 && add > INT_MAX-(INT_MAX/10)*10) {
			return 0
		}
		if res < INT_MIN/10 || (res == INT_MIN/10 && add < INT_MIN-(INT_MIN/10)*10) {
			return 0
		}
		res = res*10 + add
		x /= 10
	}
	return int(res)
}
