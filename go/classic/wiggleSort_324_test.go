package classic

import "testing"

func Test_wiggleSort(t *testing.T) {
	//a := []int{1, 5, 1, 1, 6, 4}
	//wiggleSort(a)
	//t.Log(a)
	//a = []int{1, 3, 2, 2, 3, 1}
	//wiggleSort(a)
	//t.Log(a)
	//a := []int{1,1,2,1,2,2,1}
	//wiggleSort(a)
	//t.Log(a)
	//a := []int{4,5,5,6}
	//wiggleSort(a)
	//t.Log(a)
	a := []int{5, 3, 1, 2, 6, 7, 8, 5, 5}
	wiggleSort(a)
	t.Log(a)
}
