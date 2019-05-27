/**
 * 跟全排列很像
 * 比如`abb`
 * 因为一个a可能存在于[a, bb]和[a, b, b]中
 * 也就是说当你第一个回文数是a的时候 有两种备选情况所以应该用全排列的思想来做
 * 也就是说当你找到一个回文数的时候 需要找到当前回文数后面的 回文数的所有情况
 * ···理解有问题
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
  let res = [];
  recursion(s, 0, [], res)
  return res
};

/**
 * 
 * @param {string} s 
 * @param {number} start 
 * @param {Array} temp 
 * @param {Array} res 
 */
function recursion(s, start, temp, res) {
  if (start === s.length) {
    res.push(JSON.parse(JSON.stringify(temp)))
  }
  for (let i = start; i < s.length; i++) {
    let str = s.substring(start, i + 1);
    if (isPalindrome(str)) {
      temp.push(str)
      recursion(s, i + 1, temp, res)
      temp.pop()
    }
  }
}


/**
 * 
 * @param {string} s 
 */
function isPalindrome(s) {
  for (let i = 0, j = s.length - 1; i < j; i++, j--) {
    if (s.charAt(i) !== s.charAt(j)) 
      return false;
  }
  return true;
}

console.log(partition('abb'))