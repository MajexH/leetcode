package classic

type Trie struct {
	data  []*Trie
	isEnd bool
}

/** Initialize your data structure here. */
func ConstructorForTrie() Trie {
	return Trie{
		data:  make([]*Trie, 26),
		isEnd: false,
	}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	tmp := this
	for _, char := range word {
		if tmp.data[char-'a'] == nil {
			tmp.data[char-'a'] = &Trie{
				data:  make([]*Trie, 26),
				isEnd: false,
			}
		}
		tmp = tmp.data[char-'a']
	}
	tmp.isEnd = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	tmp := this
	for _, char := range word {
		if tmp.data[char-'a'] == nil {
			return false
		}
		tmp = tmp.data[char-'a']
	}
	return tmp.isEnd
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	tmp := this
	for _, char := range prefix {
		if tmp.data[char-'a'] == nil {
			return false
		}
		tmp = tmp.data[char-'a']
	}
	return true
}
