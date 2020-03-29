function TierNode() {
  // 表示现在有多少个子节点
  this.count = 0
  // 这个地方是来存储 所有的 字符的
  // 如果只有 小写英文字母 可以存储在 数组中
  // 其实可以用map
  this.children = Array(26).fill(null)
}

// get 方法 同一个 char 即连接两个 TierNode 节点的线来连接
TierNode.prototype.get = function (char) {
  if (this.children[char.charCodeAt(0) - 97] === null) {
    this.children[charCodeAt(0) - 97] = new TierNode()
  }
  return this.children[char.charCodeAt(0) - 97]
}