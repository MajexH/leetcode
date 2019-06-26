/**
 * 采用深度优先搜索
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms1 = function(rooms) {
  let visited = Array(rooms.length).fill(false)
  recursion(visited, rooms, 0)
  return visited.reduce((pre, cur) => pre && cur, true)
};

/**
 * DFS 深度优先搜索
 * @param {boolean[]} visited 
 * @param {number[][]} rooms 
 * @param {number} index 
 */
function recursion(visited, rooms, index) {
  visited[index] = true
  for (let room of rooms[index]) {
    if (!visited[room]) {
      recursion(visited, rooms, room)
    }
  }
}

/**
 * 采用广度优先搜索
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function(rooms) {
  let visited = Array(rooms.length).fill(false), queue = []
  queue.push(0)
  while (queue.length !== 0) {
    let item = queue.shift()
    visited[item] = true
    for (let room of rooms[item]) {
      if (!visited[room]) {
        queue.push(room)
      }
    }
  }
  return visited.reduce((pre, cur) => pre && cur, true)
};


console.log(canVisitAllRooms([[1,3],[3,0,1],[2],[0]]))