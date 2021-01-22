package classic

import (
	"testing"
)

func Test_findSubstring(t *testing.T) {
	t.Log(findSubstring("wordgoodgoodgoodbestword", []string{"word", "good", "best", "good"}))
	//t.Log(findSubstring("wordgoodgoodgoodbestword", []string{"word","good","best","word"}))
}
