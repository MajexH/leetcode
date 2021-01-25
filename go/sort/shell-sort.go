package sort

// shell 排序是一个按照步长的排序
// 其本质是一个优化了步长的插入排序
func shellSort(nums []int) {
	if nums == nil || len(nums) == 0 {
		return
	}

	step := len(nums) / 2
	// 步长不停的缩短 直到最后成为插入排序（但是插入排序这个时候已经基本有序 所以跟完全乱序的相比 会有比较大的性能提升）
	for step >= 1 {
		// 插入排序
		for i := step; i < len(nums); i++ {
			exchange := nums[i]
			j := i - step
			// 将 i 位置的数 插入到 以 step 为步长的数组中间
			for ; j >= 0 && exchange < nums[j]; j -= step {
				nums[j+step] = nums[j]
			}
			// 上面已经把数据迁移完毕 只需要在 j+step 即结束迁移的位置 把需要插入的数据插入即可
			nums[j+step] = exchange
		}

		step /= 2
	}
}
