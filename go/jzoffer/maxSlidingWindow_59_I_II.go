package jzoffer

type MaxStack struct {
	data, maxes []int
}

func (ms *MaxStack) Push(val int) {
	pushedMax := val
	if len(ms.maxes) > 0 && val < ms.maxes[len(ms.maxes)-1] {
		pushedMax = ms.maxes[len(ms.maxes)-1]
	}
	ms.data = append(ms.data, val)
	ms.maxes = append(ms.maxes, pushedMax)
}

func (ms *MaxStack) Pop() int {
	returnVal := -1
	if len(ms.data) > 0 {
		returnVal = ms.data[len(ms.data)-1]
		ms.data = ms.data[:len(ms.data)-1]
		ms.maxes = ms.maxes[:len(ms.maxes)-1]
	}
	return returnVal
}

func (ms *MaxStack) Max() int {
	if len(ms.maxes) > 0 {
		return ms.maxes[len(ms.maxes)-1]
	}
	return -1
}

func (ms *MaxStack) Size() int {
	return len(ms.data)
}

type MaxQueue struct {
	s1, s2 *MaxStack
}

func (mq *MaxQueue) Push(val int) {
	mq.s1.Push(val)
}

func (mq *MaxQueue) Shift() int {
	if mq.s2.Size() <= 0 {
		for mq.s1.Size() > 0 {
			mq.s2.Push(mq.s1.Pop())
		}
	}
	return mq.s2.Pop()
}

func (mq *MaxQueue) Max() int {
	return max(mq.s1.Max(), mq.s2.Max())
}

func (mq *MaxQueue) Size() int {
	return mq.s1.Size() + mq.s2.Size()
}

func maxSlidingWindowUseMaxQueue(nums []int, k int) []int {
	if len(nums) == 0 {
		return []int{}
	}
	mq := &MaxQueue{
		s1: &MaxStack{
			data:  []int{},
			maxes: []int{},
		},
		s2: &MaxStack{
			data:  []int{},
			maxes: []int{},
		},
	}
	res := make([]int, 0)

	for i := 0; i < k; i++ {
		mq.Push(nums[i])
	}

	for i := k; i < len(nums); i++ {
		res = append(res, mq.Max())
		mq.Push(nums[i])
		mq.Shift()
	}
	res = append(res, mq.Max())
	return res
}
