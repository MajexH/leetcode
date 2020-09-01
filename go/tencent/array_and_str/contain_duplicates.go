package main

func main() {

}

func containsDuplicate(nums []int) bool {
	memo := make(map[int]int)

	for _, num := range nums {
		if _, ok := memo[num]; ok {
			return true
		}
		memo[num] = 1
	}
	return false
}
