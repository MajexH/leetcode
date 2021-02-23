package classic

type MaxMinQueue struct {
	stack1 MaxMinStack
	stack2 MaxMinStack
}

func (queue *MaxMinQueue) Push(val int) {
	queue.stack1.Push(val)
}

func (queue *MaxMinQueue) Shift() int {
	if queue.stack2.Len() == 0 {
		for queue.stack1.Len() > 0 {
			queue.stack2.Push(queue.stack1.Pop())
		}
	}
	return queue.stack2.Pop()
}

func (queue *MaxMinQueue) Max() int {
	if queue.stack1.Len() == 0 {
		return queue.stack2.Max()
	} else if queue.stack2.Len() == 0 {
		return queue.stack1.Max()
	}
	return max(queue.stack2.Max(), queue.stack1.Max())
}

func (queue *MaxMinQueue) Min() int {
	if queue.stack1.Len() == 0 {
		return queue.stack2.Min()
	} else if queue.stack2.Len() == 0 {
		return queue.stack1.Min()
	}
	return min(queue.stack2.Min(), queue.stack1.Min())
}

func (queue *MaxMinQueue) Len() int {
	return queue.stack1.Len() + queue.stack2.Len()
}

type MaxMinStack struct {
	// 这两个不用 slice 用 list 之类的链表 可能会快一点儿
	data  []int
	maxes []int
	mins  []int
}

func (ms *MaxMinStack) Push(val int) {
	ms.data = append(ms.data, val)
	if len(ms.maxes) > 0 {
		ms.maxes = append(ms.maxes, max(ms.maxes[len(ms.maxes)-1], val))
	} else {
		ms.maxes = append(ms.maxes, val)
	}

	if len(ms.mins) > 0 {
		ms.mins = append(ms.mins, min(ms.mins[len(ms.mins)-1], val))
	} else {
		ms.mins = append(ms.mins, val)
	}
}

func (ms *MaxMinStack) Pop() int {
	res := ms.data[len(ms.data)-1]
	ms.data = ms.data[:len(ms.data)-1]
	ms.maxes = ms.maxes[:len(ms.maxes)-1]
	ms.mins = ms.mins[:len(ms.mins)-1]
	return res
}

func (ms *MaxMinStack) Max() int {
	return ms.maxes[len(ms.maxes)-1]
}

func (ms *MaxMinStack) Min() int {
	return ms.mins[len(ms.mins)-1]
}

func (ms *MaxMinStack) Len() int {
	return len(ms.data)
}

// 找到一个最长的连续子数组 其任意两个元素之间的差值 小于等于 limit
func longestSubarray(nums []int, limit int) int {
	// 就是维护一个 queue 为了方便 应该在 o(1) 的时间内获得其 最大最小值
	left, right := 0, 0
	window := &MaxMinQueue{stack1: MaxMinStack{}, stack2: MaxMinStack{}}
	res := 0
	for right < len(nums) {
		window.Push(nums[right])
		if window.Len() > 0 && window.Max()-window.Min() <= limit {
			res = max(res, right-left+1)
		}

		for window.Len() > 0 && window.Max()-window.Min() > limit {
			window.Shift()
			left++
		}
		right++
	}
	return res
}
