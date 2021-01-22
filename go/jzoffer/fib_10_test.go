package jzoffer

import "testing"

func Test_recursionFib(t *testing.T) {
	t.Log(fib(45))
	t.Log(fib(2))
	t.Log(fib(100))
	//t.Log(fib(45))
	//t.Log(fib(45))
	//t.Log(fib(45))
}

func Test_fibWithoutRecursion(t *testing.T) {
	t.Log(fibWithoutRecursion(45))
	t.Log(fibWithoutRecursion(2))
	t.Log(fibWithoutRecursion(100))
}
