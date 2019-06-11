/// <reference path="/runner/typings/mocha/index.d.ts" />
/// <reference path="/runner/typings/chai/index.d.ts" />
import solution = require("./solution");

import { assert } from "chai";

describe("solution", function() {
  it("Basic Tests", function() {
    assert.equal(solution.positiveSum([1, 2, 3, 4, 5]), 15);
    assert.equal(solution.positiveSum([1, -2, 3, 4, 5]), 13);
    assert.equal(solution.positiveSum([]), 0);
    assert.equal(solution.positiveSum([-1, -2, -3, -4, -5]), 0);
    assert.equal(solution.positiveSum([-1, 2, 3, 4, -5]), 9);
  });
});
