interface Test {
  test: string
  [propertyName: string]: any
}

function toString(test: Test) {
  if (test.color) {
    console.log(test.color)
  }
}

let testVar = { test: 1, color: 2 }

toString(testVar)