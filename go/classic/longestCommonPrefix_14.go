package classic

import "fmt"

func longestCommonPrefix(strs []string) string {
	return recursion(strs, 0, len(strs)-1)
}

func recursion(strs []string, i, j int) string {
	if i > j {
		return ""
	}
	if i == j {
		return strs[i]
	}
	mid := (i + j) / 2

	return getCommonOfTwoWord(recursion(strs, i, mid), recursion(strs, mid+1, j))
}

func getCommonOfTwoWord(str1, str2 string) string {
	i, j := 0, 0

	for i < len(str1) && j < len(str2) {
		if str1[i] == str2[j] {
			i++
			j++
		} else {
			break
		}
	}
	return str1[:i]
}

func main() {
	fmt.Print(longestCommonPrefix([]string{"flower", "flow", "flight"}))
}
