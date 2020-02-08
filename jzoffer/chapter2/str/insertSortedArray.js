/**
 * des和ori都是有序的
 * ori中的数插入到des中，其中保证des能够容纳下ori的所有数
 * 为了提高效率 从后往前插入
 * @param {Array} des 
 * @param {Array} ori
 * @param {Number} desLength 表示des数组中前面的数据的长度
 */
function insertSortedArray(des, ori, desLength) {
  // 应该插入的位置
  let targetPosition = des.length - 1
  let oriPosition = ori.length - 1, desPosition = desLength - 1
  while (oriPosition >= 0 && desPosition >= 0) {
    if (des[desPosition] > ori[oriPosition]) {
      des[targetPosition--] = des[desPosition--]
    } else {
      des[targetPosition--] = ori[oriPosition--]
    }
  }
  // 如果还有没复制完的
  if (oriPosition >= 0) {
    des[targetPosition--] = ori[oriPosition--]
  }
}

let des = Array(10), ori = []
for (let i = 0; i < 10; i += 2) {
  des[i / 2] = i
}

for (let i = 1; i < 10; i += 2) {
  ori.push(i)
}

console.log(insertSortedArray(des, ori, 5))
console.log(des)
