import { generate } from 'random-words';
import chalk from 'chalk';

const word1 = generate({ exactly: 1, minLength: 10, wordsPerString: 1 })[0];
const word2 = generate();

console.log(`The ${chalk.greenBright(word1)} is ${chalk.redBright(word2)}.`);

export const sum = (a, b) => a + b;

// ESLint errors
/*
var unusedVar = 1;
if (word1 == word2) {
  console.log(undefinedVariable);
}
*/
