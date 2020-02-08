function List(data) {
  this.data = data;
  this.next = null;
}
/**
 * 从后向前输出list的值
 * 使用stack或者使用recurison
 * 实际上recursion会有额外的消耗
**/
function printListBack(list) {
  recursion(list)
}

function recursion(list) {
  if (list !== null) {
    recursion(list.next)
    console.log(list.data)
  }
}

let list = new List(0)
list.next = new List(1)
list.next.next = new List(2)
list.next.next.next = new List(3)

printListBack(list)