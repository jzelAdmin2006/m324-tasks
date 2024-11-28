import { expect } from "chai";
import { generate } from "random-words";
import {sum} from "../src/index.js";

describe("Code Tests", () => {
    it("should generate a word with at least 10 characters", () => {
        const word1 = generate({ exactly: 1, minLength: 10, wordsPerString: 1 })[0];
        expect(word1).to.be.a("string");
        expect(word1.length).to.be.at.least(10);
    });

    it("should generate a random word", () => {
        const word2 = generate();
        expect(word2).to.be.a("string");
    });

    it("should correctly calculate the sum of two numbers", () => {
        expect(sum(2, 3)).to.equal(5);
        expect(sum(-1, 1)).to.equal(0);
        expect(sum(0, 0)).to.equal(0);
        expect(sum(1, 2)).to.equal(3);
    });
});
