/*
 * @lc app=leetcode id=146 lang=javascript
 *
 * [146] LRU Cache
 */

// @lc code=start
function LRUNode(key, val) {
  this.key = key
  this.val = val
  this.pre = null
  this.next = null
}

LRUNode.prototype.remove = function () {
  this.pre.next = this.next
  this.next.pre = this.pre
  return this
}

/**
 * 先后顺序可以由链表的插入节点来表示 
 * 如采用头插法 则越在尾部的 越是没有用过
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
  this.capacity = capacity
  // 保存对应关系
  this.save = new Map()
  this.start = new LRUNode()
  this.end = new LRUNode()

  this.start.next = this.end
  this.end.pre = this.start
};

LRUCache.prototype.addFirst = function (node) {
  node.next = this.start.next
  this.start.next = node

  node.next.pre = node
  node.pre = this.start
}

LRUCache.prototype.removeLast = function () {
  // 防止start节点被删除
  if (this.end.pre === this.start) return
  return this.end.pre.remove()
}

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
  if (this.save.has(key)) {
    // 将最近访问的移到顶部
    let node = this.save.get(key)
    node.remove()
    this.addFirst(node)
    return node.val
  } else {
    return -1
  }
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
  // 如果有
  if (this.save.has(key)) {
    let node = this.save.get(key)
    node.val = value
    node.remove()
    this.addFirst(node)
  } else {
  // 如果没有
    let node = new LRUNode(key, value)
    if (this.save.size >= this.capacity) {
      let removeNode = this.removeLast()
      this.save.delete(removeNode.key)
    }
    this.addFirst(node)
    this.save.set(key, node)
  }
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
// @lc code=end

let cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
console.log(cache.get(1));       // returns 1
cache.put(3, 3);    // evicts key 2
console.log(cache)
console.log(cache.get(2));       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
console.log(cache.get(1));       // returns -1 (not found)
console.log(cache.get(3));       // returns 3
console.log(cache.get(4));       // returns 4