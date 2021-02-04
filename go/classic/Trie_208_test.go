package classic

import (
	"testing"
)

func TestConstructorForTrie(t *testing.T) {
	trie := ConstructorForTrie()
	trie.Insert("apple")
	t.Log(trie.Search("apple"))   // 返回 true
	t.Log(trie.Search("app"))     // 返回 false
	t.Log(trie.StartsWith("app")) // 返回 true
	trie.Insert("app")
	t.Log(trie.Search("app")) // 返回 true
}
