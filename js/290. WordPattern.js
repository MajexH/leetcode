/**
 * @param {string} pattern
 * @param {string} str
 * @return {boolean}
 */
var wordPattern = function(pattern, str) {
  let map = new Map(), strArray = str.split(' ');
  if (strArray.length !== pattern.length) {
    return false
  }
  for (let i = 0; i < pattern.length; i++) {
    if (!map.has(pattern[i])) {
      let temp = []
      temp.push(i)
      map.set(pattern[i], temp)
    } else {
      let temp = map.get(pattern[i])
      temp.push(i)
      map.set(pattern[i], temp)
    }
  }
  if ([...new Set(map.keys())].length !== [...new Set(strArray)].length) {
    return false
  }
  for (let val of map.values()) {
    for (let i = 1; i < val.length; i++) {
      if (strArray[val[0]] !== strArray[val[i]]) {
        return false
      }
    }
  }
  return true
};

console.log(wordPattern("aba", "cat cat cat dog"))