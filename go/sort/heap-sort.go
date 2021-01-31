package sort

func defaultCompare(a, b int) bool {
	return a > b
}

// Heap 根据输入的 compare 构建不同的堆
// 默认小顶堆 -> 从大到小排列
type Heap struct {
	nums    []int
	compare func(a, b int) bool
}

// shiftDown 移动顶层的向下
func (h *Heap) shiftDown(k, n int) {
	for 2*k+1 <= n {
		j := 2*k + 1
		// 注意这个地方 大顶堆的时候 因为需要把小的东西往下沉 所以需要选择的是 子节点中 的较大值
		// 小顶堆的时候 由于需要把大的东西往下沉 所以需要选取的是较小值 （因为比较小值小 这个节点一定比两个节点都小）
		if j+1 <= n && h.compare(h.nums[j], h.nums[j+1]) {
			j++
		}
		if h.compare(h.nums[j], h.nums[k]) {
			break
		}
		swap(h.nums, k, j)
		k = j
	}
}

// popUp 最下面的浮动到最上面
func (h *Heap) popUp(k int) {
	for k >= 0 {
		var father int
		if k%2 == 1 {
			father = k / 2
		} else {
			father = k/2 - 1
		}
		if h.compare(h.nums[k], h.nums[father]) {
			break
		}
		swap(h.nums, father, k)
		k = father
	}
}

func NewHeap(nums []int) *Heap {
	return &Heap{nums: nums, compare: defaultCompare}
}

func NewHeapWithCompare(nums []int, compare func(a, b int) bool) *Heap {
	return &Heap{nums: nums, compare: compare}
}

func (h *Heap) Sort() {
	n := len(h.nums) - 1

	// 首先将输入构造成堆
	for i := n / 2; i >= 0; i-- {
		h.shiftDown(i, n)
	}
	// 这样排序是吧最小的排在后面
	for n >= 0 {
		swap(h.nums, 0, n)
		n--
		h.shiftDown(0, n)
	}
}
