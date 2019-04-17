/**
 * @param {string} s
 * @return {string}
 */
var frequencySort = function(s) {
  let map = new Map(), array = [];
  for (let item of s) {
    if (map.get(item) !== undefined) {
      map.set(item, map.get(item) + 1)
    } else {
      map.set(item, 0)
    }
  }
  for (let key of map.keys()) {
    array.push({
      key,
      val: map.get(key)
    })
  }
  array.sort((a, b) => { return b.val - a.val })
  let result = '';
  for (let item of array) {
    for (let i = 0; i <= item.val; i++) {
      result += item.key;
    }
  }
  return result
};

console.log(frequencySort('Aabb'))