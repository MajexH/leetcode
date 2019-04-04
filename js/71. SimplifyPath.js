/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
  let stack = []
  let origin = path.split('/')
  for (let item of origin) {
    if (item === '.' || item.length === 0) {
      continue;
    }
    if (item === '..') {
      if (stack.length != 0)
        stack.pop()
    } else {
      stack.push(item)
    }
  }
  let result = '/'
  for (let item of stack) {
    result += item + '/'
  }
  if (result === '/') return result 
  return result.substr(0, result.length - 1)
};

console.log(simplifyPath("/../"))