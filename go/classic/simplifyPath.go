package classic

import (
	"bytes"
	"container/list"
	"strings"
)

func simplifyPath(path string) string {
	if len(path) == 0 {
		return ""
	}
	strs := strings.Split(path, "/")
	stack := list.New()

	for _, str := range strs {
		if str == ".." {
			if stack.Len() > 0 {
				stack.Remove(stack.Back())
			}
			continue
		}
		if len(str) == 0 || str == "." {
			continue
		}
		stack.PushBack(str)
	}

	if stack.Len() == 0 {
		return "/"
	}
	res := bytes.Buffer{}

	for stack.Len() > 0 {
		res.WriteString("/")
		res.WriteString(stack.Remove(stack.Front()).(string))
	}
	return res.String()
}
