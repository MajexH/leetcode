package classic

import "container/list"

func ladderLength(beginWord string, endWord string, wordList []string) int {
	wordMap := make(map[string][]string)

	for _, word := range wordList {
		for i := 0; i < len(word); i++ {
			str := word[0:i] + "*" + word[i+1:]
			wordMap[str] = append(wordMap[str], word)
		}
	}
	// bfs 就可以找到最短的了
	return bfsLadderLength(beginWord, endWord, wordMap)
}

func bfsLadderLength(beginWord string, endWord string, wordMap map[string][]string) int {
	type item struct {
		word  string
		level int
	}
	memo := make(map[string]int)
	queue := list.New()
	queue.PushBack(&item{
		word:  beginWord,
		level: 1,
	})
	for queue.Len() > 0 {
		top := queue.Remove(queue.Front()).(*item)
		memo[top.word] = 1
		if top.word == endWord {
			return top.level
		}
		// 遍历通配符
		for i := 0; i < len(top.word); i++ {
			str := top.word[0:i] + "*" + top.word[i+1:]
			// 遍历传入的 word
			for _, word := range wordMap[str] {
				if _, ok := memo[word]; ok {
					continue
				}
				queue.PushBack(&item{
					word:  word,
					level: top.level + 1,
				})
			}
		}
	}
	return 0
}
