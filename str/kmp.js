/**
 * 
 * @param {String} str 
 */
function getNext(str) {
  let next = [-1]
  let k = -1, j = 0
  while (j < str.length) {
    if (k === -1 || str.charAt(k) === str.charAt(j)) {
      ++k
      ++j
      next[j] = k
    } else {
      k = next[k]
    }
  }
  return next
}

/**
 * 
 * @param {String} str 
 * @param {String} pattern
 */
function kmp(str, pattern) {
  let i = 0, j = 0
  let next = getNext(pattern)
  while (i < str.length && j < pattern.length) {
    // 如果匹配
    if (j === - 1 || str.charAt(i) === pattern.charAt(j)) {
      i++
      j++
    } else {
    // 失配 更新j值
      j = next[j]
    }
  }
  if (j === pattern.length)
    return i - j;
  else
    return -1;
}

const kmp1 = (next, str) => {
  next[0] = 0;
  let len = 0;
  let i = 1;
  while (i < str.length) {
    if (str[i] == str[len]) {
      len++;
      next[i] = len;
      i++;
    } else {
      if (len == 0) {
        next[i] = 0;
        i++;
      } else {
        len = next[len - 1];
      }
    }
  }
};

const shortestPalindrome = (s) => {
  const rev_s = s.split('').reverse().join('');
  const str = s + "#" + rev_s;
  const next = new Array(str.length).fill(0);
  // 抽出来，方便学习记忆，这是我写的模板
  const kmp = (next, str) => {
    next[0] = 0;
    let len = 0;
    let i = 1;
    while (i < str.length) {
      if (str[i] == str[len]) {
        len++;
        next[i] = len;
        i++;
      } else {
        if (len == 0) {
          next[i] = 0;
          i++;
        } else {
          len = next[len - 1];
        }
      }
    }
  };
  kmp(next, str);
  const maxLen = next[str.length - 1]; // 最长回文前缀的长度
  const add = s.substring(maxLen).split('').reverse().join('');
  return add + s;
};


// let next = []
// console.log(kmp1(next, "aaaaa"))
// console.log(next)
// console.log(getNext("aaaaa"))

console.log(shortestPalindrome("aacecaaa"))
