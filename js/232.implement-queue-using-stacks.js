/*
 * @lc app=leetcode id=232 lang=javascript
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
/**
 * Initialize your data structure here.
 */
var MyQueue = function() {
    this.data = []
};

/**
 * Push element x to the back of queue. 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.data.push(x)
};

/**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
MyQueue.prototype.pop = function() {
  let temp = []
  while (this.data.length > 1) {
    temp.push(this.data.pop())
  }
  let res = this.data.pop()
  while (temp.length > 0) {
    this.data.push(temp.pop())
  }
  return res
};

/**
 * Get the front element.
 * @return {number}
 */
MyQueue.prototype.peek = function() {
  let temp = []
  while (this.data.length > 1) {
    temp.push(this.data.pop())
  }
  let res = this.data.pop()
  this.data.push(res)
  while (temp.length > 0) {
    this.data.push(temp.pop())
  }
  return res
};

/**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
  return this.data.length === 0
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
// @lc code=end

