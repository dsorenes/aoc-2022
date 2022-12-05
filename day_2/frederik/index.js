const fs = require("fs");
const data = fs.readFileSync("./input.txt", "utf8");
const list = data.split("\n");

const shapeScores = {
  A: 1,
  B: 2,
  C: 3,
  X: 1,
  Y: 2,
  Z: 3,
};

const outcomeScores = {
  A: {
    X: 3,
    Y: 6,
    Z: 0,
  },
  B: {
    X: 0,
    Y: 3,
    Z: 6,
  },
  C: {
    X: 6,
    Y: 0,
    Z: 3,
  },
};

let totalScore = 0;

for (round of list) {
  const [opponent, player] = round.split(" ");
  const shapeScore = shapeScores[player];
  const outcomeScore = outcomeScores[opponent][player];
  const roundScore = shapeScore + outcomeScore;
  totalScore += roundScore;
}

console.log(totalScore);

// Part 2

const winningShapeScores = {
  A: 2,
  B: 3,
  C: 1,
};

const losingShapeScores = {
  A: 3,
  B: 1,
  C: 2,
};

let totalScoreB = 0;

for (round of list) {
  const [opponent, player] = round.split(" ");

  if (player === "X") {
    totalScoreB += losingShapeScores[opponent];
  } else if (player === "Y") {
    totalScoreB += shapeScores[opponent];
    totalScoreB += 3;
  } else {
    totalScoreB += winningShapeScores[opponent];
    totalScoreB += 6;
  }
}

console.log(totalScoreB);
