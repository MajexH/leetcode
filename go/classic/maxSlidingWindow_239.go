package classic

type MaxQueue struct {
	stack1 MaxStack
	stack2 MaxStack
}

func (queue *MaxQueue) Push(val int) {
	queue.stack1.Push(val)
}

func (queue *MaxQueue) shift() int {
	if queue.stack2.Len() == 0 {
		for queue.stack1.Len() > 0 {
			queue.stack2.Push(queue.stack1.Pop())
		}
	}
	return queue.stack2.Pop()
}

func (queue *MaxQueue) Max() int {
	if queue.stack1.Len() == 0 {
		return queue.stack2.Max()
	} else if queue.stack2.Len() == 0 {
		return queue.stack1.Max()
	}
	return max(queue.stack2.Max(), queue.stack1.Max())
}

func (queue *MaxQueue) Len() int {
	return queue.stack1.Len() + queue.stack2.Len()
}

type MaxStack struct {
	// 这两个不用 slice 用 list 之类的链表 可能会快一点儿
	data  []int
	maxes []int
}

func (ms *MaxStack) Push(val int) {
	ms.data = append(ms.data, val)
	if len(ms.maxes) > 0 {
		ms.maxes = append(ms.maxes, max(ms.maxes[len(ms.maxes)-1], val))
	} else {
		ms.maxes = append(ms.maxes, val)
	}
}

func (ms *MaxStack) Pop() int {
	res := ms.data[len(ms.data)-1]
	ms.data = ms.data[:len(ms.data)-1]
	ms.maxes = ms.maxes[:len(ms.maxes)-1]
	return res
}

func (ms *MaxStack) Max() int {
	return ms.maxes[len(ms.maxes)-1]
}

func (ms *MaxStack) Len() int {
	return len(ms.data)
}

func maxSlidingWindow(nums []int, k int) []int {
	queue := MaxQueue{
		stack1: MaxStack{},
		stack2: MaxStack{},
	}

	for i := 0; i < k; i++ {
		queue.Push(nums[i])
	}
	res := make([]int, 0)
	for i := k; i < len(nums); i++ {
		res = append(res, queue.Max())
		queue.shift()
		queue.Push(nums[i])
	}
	res = append(res, queue.Max())
	return res
}
