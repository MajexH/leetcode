function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumRootToLeaf = function(root) {
  let result = [], number = 0
  dfs(root, [], result)
  for (let i = 0, j = result[0].length - 1; i < result[0].length; i++, j--) {
    number += Math.pow(2, j) * result[0][i]
  }
  return number
};

/**
 * 
 * @param {TreeNode} node 
 * @param {Array} temp
 * @param {Array} result
 */
function dfs(node, temp, result) {
  if (node) {
    temp.push(node.val)
  }
  else
    return
  if (!node.left && !node.right) {
    if (result.length === 0) {
      result.push(temp.join(''))
    } else {
      result.push(addTwoBinary(result.pop(), temp.join('')))
    }
    return
  }
  dfs(node.left, JSON.parse(JSON.stringify(temp)), result)
  dfs(node.right, JSON.parse(JSON.stringify(temp)), result)
}

function addTwoBinary (a, b) {
  let i = a.length - 1, j = b.length - 1, add = 0, result = [];
  while (true) {
    let temp = (i >= 0 ? Number.parseInt(a[i--]) : 0) + (j >= 0 ? Number.parseInt(b[j--]) : 0) + add;
    add = Math.floor(temp / 2);
    result.unshift(temp % 2);
    if (i < 0 && j < 0)
      break;
  }
  if (add !== 0)
    result.unshift(add)
  return result.join('')
}

let p = new TreeNode(1)
p.left = new TreeNode(1)


/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumRootToLeaf1 = function(root) {
  let result = []
  dfs1(root, 0, result)
  return result[0]
};

/**
 * 可以修改成在dfs的时候 边dfs 边算和
 * @param {TreeNode} node 
 * @param {Array} temp
 * @param {Array} result
 */
function dfs1(node, temp, result) {
  if (node) {
    temp = temp * 2 + node.val
  }
  else
    return
  if (!node.left && !node.right) {
    if (result.length === 0) {
      result.push(temp)
    } else {
      result.push(result.pop() + temp)
    }
    return
  }
  dfs1(node.left, temp, result)
  dfs1(node.right, temp, result)
}

console.log(sumRootToLeaf1(p))