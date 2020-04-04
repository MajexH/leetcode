let a = {
  b: 1,
  c: function() {
    console.log(this)
    return this.b
  }
}

console.log(a.c())
b = 12312
let d = a.c

console.log(d())