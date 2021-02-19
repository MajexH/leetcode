package binarySearch

// 找到一个刚好大于 target 的 byte letters 生序排列
// 其实就是找到插入这个数字的最右边的位置
func nextGreatestLetter(letters []byte, target byte) byte {
	i, j := 0, len(letters)

	for i < j {
		mid := i + (j-i)/2
		// 因为要找到刚刚大于的 左右 i 要往前进
		if letters[mid] > target {
			j = mid
		} else {
			i = mid + 1
		}
	}
	return letters[i%len(letters)]
}
