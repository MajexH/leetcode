/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {
  let count = 0;
  for (let i = 2; i < n; i++) {
    if (isPrime(i)) {
      console.log(i)
      count++;
    }
  }
  return count
};

/**
 * 
 * @param {number} number 
 */
function isPrime(number) {
  for (let i = 2; i <= Math.sqrt(number); i++) {
    if (number % i == 0) {
      return false
    }
  }
  return true
}

console.log(countPrimes(10))