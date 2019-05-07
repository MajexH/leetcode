/**
 * @param {string[]} list1
 * @param {string[]} list2
 * @return {string[]}
 */
var findRestaurant = function(list1, list2) {
  let result = {
    count: list1.length + list2.length
  };
  for (let i = 0; i < list1.length; i++) {
    for (let j = 0; j < list2.length; j++) {
      if (compareTwoString(list1[i], list2[j])) {
        if (i + j < result.count) {
          result = {
            count: i + j,
            array: [list1[i]]
          }
        } else if (i + j === result.count) {
          result.array.push(list1[i])
        }
      }
    }
  }
  return result.array
};

function compareTwoString(str1, str2) {
  if (str1.length !== str2.length) return false
  for (let i = 0; i < str1.length; i++) {
    if (str1[i] !== str2[i]) return false
  }
  return true
}

console.log(findRestaurant(["Shogun","Tapioca Express","Burger King","KFC"], ["KNN","KFC","Burger King","Tapioca Express","Shogun"]))