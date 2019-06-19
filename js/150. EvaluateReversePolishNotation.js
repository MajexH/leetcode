/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
  let numberStack = []
  for (let item of tokens) {
    // 是数字
    if ((item.charCodeAt(0) >= 48 && item.charCodeAt(0) <= 57) || (item.charCodeAt(0) === 45 && item.length > 1)) {
      numberStack.push(Number.parseFloat(item))
    } else {
    // 是操作符
      let last = numberStack.pop(), pre = numberStack.pop(), res
      switch (item) {
        case '+':
          res = pre + last
          break;
        case '-':
          res = pre - last
          break;
        case '*':
          res = pre * last
          break;
        case '/':
          res = pre / last
          if (res < 0)
            res = Math.ceil(res)
          else 
            res = Math.floor(res)
          break
      }
      console.log(pre, last, item, res)
      numberStack.push(res)
    }
  }
  return numberStack.pop()
};

console.log(evalRPN(["0","3","/"]))