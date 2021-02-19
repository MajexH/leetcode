package classic

import "sort"

func hIndex(citations []int) int {
	sort.Ints(citations)
	res := 0
	for i, citation := range citations {
		// i 表示的是篇数 因为排序了 所以后面的篇数一定比是现在 i 的引用多的
		// len(citations) - i 后面的大于 当前论文引用数的论文数量
		// 所以后面的论文 至少引用了这么 citation 篇 之前的论文 一定小于 citation 篇
		if len(citations)-i <= citation && len(citations)-i > res {
			res = len(citations) - i
		}
	}
	return res
}
