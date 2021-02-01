package classic

func getSum(nums []int) int {
	sum := 0
	for _, num := range nums {
		sum += num
	}
	return sum
}

func canCompleteCircuit(gas []int, cost []int) int {

	gasSum, costSum := getSum(gas), getSum(cost)
	if gasSum < costSum {
		return -1
	}
	totalGas := 0
	startStation := 0
	for i := 0; i < len(gas); i++ {
		totalGas += gas[i] - cost[i]
		// 不能开到下一个站点
		if totalGas < 0 {
			// 重新开始
			totalGas = 0
			startStation = i + 1
			continue
		}
	}

	return startStation
}
