const fs = require("fs");
const data = fs.readFileSync("./input.txt", "utf8");
const list = data.split("\n");

let caloriesTmp = 0;
let elves = [];

for (item of list) {
  if (item) {
    const value = parseInt(item, 10);
    caloriesTmp += value;
  } else {
    elves.push(caloriesTmp);
    caloriesTmp = 0;
  }
}

elves.sort((a, b) => b - a);

console.log("Part 1 - Max:", elves[0]);
console.log("Part 2 - Top 3 total:", elves[0] + elves[1] + elves[2]);
