const fs = require("fs");
const data = fs.readFileSync("./input.txt", "utf8");
const list = data.split("\n");

let sumOverlaps = 0;

for (line of list) {
  const [first, second] = line.split(",");
  const [firstMin, firstMax] = first.split("-").map((i) => parseInt(i, 10));
  const [secondMin, secondMax] = second.split("-").map((i) => parseInt(i, 10));

  if (
    (firstMin <= secondMin && firstMax >= secondMax) ||
    (secondMin <= firstMin && secondMax >= firstMax)
  ) {
    sumOverlaps++;
  }
}

console.log(sumOverlaps);

let sumOverlapsB = 0;

for (line of list) {
  const [first, second] = line.split(",");
  const [firstMin, firstMax] = first.split("-").map((i) => parseInt(i, 10));
  const [secondMin, secondMax] = second.split("-").map((i) => parseInt(i, 10));

  if (!(firstMax < secondMin || secondMax < firstMin)) {
    sumOverlapsB++;
  }
}

console.log(sumOverlapsB);
