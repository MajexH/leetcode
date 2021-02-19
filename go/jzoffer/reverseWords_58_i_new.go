package jzoffer

import (
	"bytes"
	"strings"
)

func reverseStr(s string) string {
	byteArray := []byte(s)

	for i, j := 0, len(byteArray)-1; i < j; i, j = i+1, j-1 {
		tmp := byteArray[i]
		byteArray[i] = byteArray[j]
		byteArray[j] = tmp
	}

	return string(byteArray)
}

func reverseWordsNew(s string) string {
	s = strings.TrimSpace(s)
	strs := strings.Split(reverseStr(s), " ")
	builder := bytes.Buffer{}
	for _, str := range strs {
		if len(str) <= 0 {
			continue
		}
		builder.WriteString(reverseStr(strings.TrimSpace(str)))
		builder.WriteString(" ")
	}
	return strings.TrimSpace(builder.String())
}
