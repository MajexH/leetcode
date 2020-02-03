function Queue() {
  this.stack1 = []
  this.stack2 = []
}

Queue.prototype.appendTail = function (val) {
  this.stack1.push(val)
}

Queue.prototype.deletaHead = function () {
  if (this.stack1.length === 0 && this.stack2.length === 0) return null
  if (this.stack2.length === 0) {
    while (this.stack1.length !== 0) {
      this.stack2.push(this.stack1.pop())
    }
  }
  return this.stack2.pop()
}

let a = new Queue()

for (let i = 0; i < 3; i ++) {
  a.appendTail(i)
}

console.log(a.deletaHead())
console.log(a.deletaHead())
console.log(a.deletaHead())
console.log(a.deletaHead())
console.log(a.deletaHead())
console.log(a.deletaHead())