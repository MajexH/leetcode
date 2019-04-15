function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * 肯定要把数组的中间位置的东西插到根节点上
 * 我的想法是吧左右都做个指针 然后左右同时查 判断左右的长度差是否超过1 超过1 就插在同一层
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function(nums) {
    
};