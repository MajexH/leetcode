/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
  let i = 0, j = s.length - 1;
  while (i < j) {
    let left = checkVowels(s[i]), right = checkVowels(s[j])
    if (left && right) {
      s = s.substr(0, i) + s[j] + s.substring(i + 1, j) + s[i] + s.substring(j + 1, s.length)
      i++
      j--
      continue
    }
    if (!left) {
      i++
    }
    if (!right) {
      j--
    }
  }
  return s
};

function checkVowels(char) {
  return ['A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'].findIndex((val) => char === val) !== -1
}

console.log(reverseVowels('hello'))