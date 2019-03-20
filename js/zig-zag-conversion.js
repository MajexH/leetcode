/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
  let list = [], result =  '';
  if (numRows === 1) {
    return s;
  }
  for (let i = 0; i < numRows; i++) {
    list.push(new String())
  }
  let goDown = false, currentRow = 0;
  for (let i = 0; i < s.length; i++) {
    if (i % (numRows - 1) === 0) {
      goDown = !goDown
    }
    list[currentRow] += s[i]
    currentRow += goDown ? 1 : -1;
  }
  for (let str of list) {
    result += str
  }
  return result
};

console.log(convert("AB", 1));