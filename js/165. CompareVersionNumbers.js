/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
  let i = 0, j = 0;
  let v1Array = version1.split('.'), v2Array = version2.split('.');
  while (i < v1Array.length || j < v2Array.length) {
    let v1Number = i >= v1Array.length ? 0 : Number.parseInt(v1Array[i++])
    let v2Number = j >= v2Array.length ? 0 : Number.parseInt(v2Array[j++])
    if (v1Number < v2Number) {
      return -1;
    } else if (v1Number > v2Number) {
      return 1;
    }
  }
  return 0;
};

console.log(compareVersion('1.0', '1.00'))