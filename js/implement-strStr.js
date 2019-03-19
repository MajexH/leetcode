/**
 * next实际上就是字符串自己跟自己匹配
 * @param {String} p 
 */
function getNext(p) {
  let next = [];
  next[0] = -1;
  let i = 0, j = -1;
  while (i < p.length) {
    if (j === -1 || p[i] === p[j]) {
      // 如果匹配
      j++;
      i++;
      next[i] = j;
    } else {
      j = next[j]
    }
  }
  return next;
}

/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
  let next = getNext(needle);
  let i = 0, j = 0;
  while (i < haystack.length && j < needle.length) {
    if (j === -1 || haystack[i] === needle[j]) {
      i++;
      j++;
    } else {
      j = next[j];
    }
  }
  if (j === needle.length) {
    return i - j;
  } else {
    return -1;
  }
};

console.log(strStr("aaaaa", "bba"));