const fs = require("fs");
const data = fs.readFileSync("./input.txt", "utf8").split("\n");

function createStacks() {
  const stacks = {
    1: [],
    2: [],
    3: [],
    4: [],
    5: [],
    6: [],
    7: [],
    8: [],
    9: [],
  };

  for (let i = 7; i >= 0; i--) {
    const line = data[i];

    for (let j = 0; j < 9; j++) {
      const cargo = line.charAt(j * 4 + 1);

      if (cargo !== " ") stacks[(j + 1).toString()].push(cargo);
    }
  }

  return stacks;
}

function printStacks(stacks) {
  let output = "";

  for (let i = 1; i < 10; i++) {
    const stack = stacks[i.toString()];
    output += stack[stack.length - 1];
  }

  console.log(output);
}

function partA() {
  const stacks = createStacks();

  for (let i = 10; i < data.length; i++) {
    const line = data[i].split(" ");
    const [cargoNumber, from, to] = [line[1], line[3], line[5]];

    for (let j = 0; j < cargoNumber; j++) {
      const cargoToMove = stacks[from].pop();
      stacks[to].push(cargoToMove);
    }
  }

  printStacks(stacks);
}

function partB() {
  const stacks = createStacks();

  for (let i = 10; i < data.length; i++) {
    const line = data[i].split(" ");
    const [cargoNumber, from, to] = [line[1], line[3], line[5]];

    stacks[to] = stacks[to].concat(stacks[from].splice(-cargoNumber));
  }

  printStacks(stacks);
}

partA();
partB();
