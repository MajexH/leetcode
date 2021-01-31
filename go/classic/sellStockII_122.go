package classic

// 这个要求多次买买（实际上就是找到最低峰和最高谷）
func maxProfitII(prices []int) int {
	if prices == nil || len(prices) < 2 {
		return 0
	}
	high, low := 0, 0
	res := 0
	for i := 0; i < len(prices)-1; {
		// 先找低谷
		for i < len(prices)-1 && prices[i] >= prices[i+1] {
			i++
		}
		low = prices[i]
		// 找到 peak
		for i < len(prices)-1 && prices[i] <= prices[i+1] {
			i++
		}
		high = prices[i]
		res += high - low
	}
	return res
}
