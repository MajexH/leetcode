
let e = {
  a: 1,
  e: 2
}
let a = {
  b: 1,
  c: function() {
    console.log(this)
    return this
  }.bind(e)
}

console.log(a.c())
b = 12312
let d = a.c

console.log(d())

// let obj = new Proxy({}, {
//   // receiver 指的是接受这个变化的对象
//   get: function(target, propKey, receiver) {
//     console.log(receiver)
//     return Reflect.get(target, propKey, receiver)
//   },
//   set: function (target, propKey, value, receiver) {
//     console.log(receiver)
//     return Reflect.set(target, propKey, value, receiver);
//   }
// })

// obj.test = 1
// obj.test += 1