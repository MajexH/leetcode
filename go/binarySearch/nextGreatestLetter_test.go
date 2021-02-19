package binarySearch

import "testing"

func Test_nextGreatestLetter(t *testing.T) {
	t.Logf("%c", nextGreatestLetter([]byte{'c', 'f', 'j'}, 'a'))
	t.Logf("%c", nextGreatestLetter([]byte{'c', 'f', 'j'}, 'c'))
	t.Logf("%c", nextGreatestLetter([]byte{'c', 'f', 'j'}, 'd'))
	t.Logf("%c", nextGreatestLetter([]byte{'c', 'f', 'j'}, 'g'))
	t.Logf("%c", nextGreatestLetter([]byte{'c', 'f', 'j'}, 'j'))
	t.Logf("%c", nextGreatestLetter([]byte{'c', 'f', 'j'}, 'k'))
}
