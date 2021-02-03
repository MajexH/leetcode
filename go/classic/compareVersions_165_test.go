package classic

import "testing"

func Test_compareVersion(t *testing.T) {
	t.Log(compareVersion("1.01", "1.001"))
	t.Log(compareVersion("1.0", "1.0.0"))
	t.Log(compareVersion("0.1", "1.1"))
	t.Log(compareVersion("1.0.1", "1"))
	t.Log(compareVersion("7.5.2.4", "7.5.3"))
}
