package main

func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	reverse := 0
	for num := x; num != 0; num /= 10 {
		reverse = reverse*10 + num%10
	}

	return reverse == x
}
