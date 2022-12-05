const fs = require("fs");
const data = fs.readFileSync("./input.txt", "utf8");
const list = data.split("\n");

let sum = 0;

function findCommonLetters(stringA, stringB) {
  const setA = new Set(stringA);
  return [...new Set(stringB)].filter((char) => setA.has(char));
}

function letterToValue(letter) {
  let value = letter.charCodeAt(0) - 96;

  // A-Z
  if (value < 0) {
    value += 58;
  }

  return value;
}

for (line of list) {
  const [first, second] = [
    line.slice(0, line.length / 2),
    line.slice(line.length / 2),
  ];

  const commonLetter = findCommonLetters(first, second)[0];
  sum += letterToValue(commonLetter);
}

console.log(sum);

let sumB = 0;

for (let i = 0; i < list.length; i += 3) {
  const commonLettersFirstSecond = findCommonLetters(list[i], list[i + 1]);
  const commonLetter = findCommonLetters(
    commonLettersFirstSecond.join(),
    list[i + 2]
  )[0];
  sumB += letterToValue(commonLetter);
}

console.log(sumB);
