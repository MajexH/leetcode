package classic

import (
	"container/list"
	"sort"
)

func deckRevealedIncreasing(deck []int) []int {
	if len(deck) == 0 {
		return []int{}
	}
	sort.Ints(deck)

	res := make([]int, len(deck))

	queue := list.New()

	for i := 0; i < len(deck); i++ {
		queue.PushBack(i)
	}

	for _, num := range deck {
		top := queue.Remove(queue.Front()).(int)
		res[top] = num
		if queue.Len() > 0 {
			queue.PushBack(queue.Remove(queue.Front()))
		}
	}

	return res
}
