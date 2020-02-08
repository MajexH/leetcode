function fRecurison(n) {
  if (n <= 0) {
    return 0
  } else if (n === 1) {
    return 1
  } else return fRecurison(n - 1) + fRecurison(n - 2)
}

function fRecurisonWithMemo(n, memo) {
  if (n <= 0) {
    return memo[0]
  } else if (n === 1) {
    return memo[1]
  } else {
    if (memo[n] === -1) 
      memo[n] = fRecurisonWithMemo(n - 1, memo) + fRecurisonWithMemo(n - 2, memo)
    return memo[n]
  }
}

let n = 100, memo = Array(n + 1).fill(-1);
memo[0] = 0; memo[1] = 1;
// console.log(fRecurison(n))
console.log(fRecurisonWithMemo(n, memo))
console.log(fWithoutRecursion(n))

function fWithoutRecursion(n) {
  if (n <= 0) return 0
  let a = 0, b = 1, c = 1, counter = 1
  while (counter < n) {
    c = a + b
    a = b
    b = c
    counter++
  }
  return c
}