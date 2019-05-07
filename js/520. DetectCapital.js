/**
 * @param {string} word
 * @return {boolean}
 */
var detectCapitalUse = function(word) {
  if (word.length <= 1) {
    return true
  }
  // 如果首字母是大写
  if (word[0].charCodeAt(0) <= 90) {
    // 第二位是小写 所有的都必须是小写
    if (word[1].charCodeAt(0) >= 97) {
      for (let i = 2; i < word.length; i++) {
        
        if (word[i].charCodeAt(0) <= 90) return false
      }
    } else {
      for (let i = 2; i < word.length; i++) {
        if (word[i].charCodeAt(0) >= 97) return false
      }
    }
    return true
  } else {
    for (let i = 1; i < word.length; i++) {
      if (word[i].charCodeAt(0) <= 90)
        return false
    }
    return true
  }
};

console.log(detectCapitalUse("Facebook"))