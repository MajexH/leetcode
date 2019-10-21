/**
 * 
 * @param {String} str 
 */
function get(str) {
  // 用来记录当前位置上的字母出现的第一个位置
  let array = Array(str.length)
  // map用来记录每个字母出现的第一个位置 有非字母的存在
  let map = Array(255).fill(-1)

  for (let i = 0; i < str.length; i++) {
    let temp = str.charCodeAt(i)
    if (map[temp] == -1) {
      map[temp] = i
      array[i] = i
    } else {
      array[i] = map[temp]
    }
  }
  return array
}

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {
  if (s.length !== t.length) return false
  let a = get(s), b= get(t)
  for (let i = 0, j = 0; i < s.length; i++, j++) {
    if (a[i] !== b[j]) return false
  }
  return true
};

console.log(isIsomorphic('32767', '65535'))