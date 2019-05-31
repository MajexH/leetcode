/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  let map = new Map(), res = []
  for (let str of strs) {
    let hash = getHash(str)
    if (map.has(hash)) {
      let temp = map.get(hash)
      temp.push(str)
    } else {
      let temp = []
      temp.push(str)
      map.set(hash, temp)
    }
  }
  for (let array of map.values()) {
    res.push(array)
  }
  return res
};

/**
 * 既然他只是去一组string 其中 string的每个char都是一样的 而且都是小写字母 因此 可以直接用类似 hash的做
 */
function getHash(str) {
  let array = Array(26).fill(0), sub = 'a'.charCodeAt(0)
  for (let i = 0; i < str.length; i++) {
    array[str.charCodeAt(i) - sub] += 1;
  }
  let res = ''
  for (let item of array) {
    res += item
  }
  return res
}

console.log(groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))