function unflatten(flatArray) {
    let result = [];
    let sub = [];
    let subCounter = 0;
    for (const val of flatArray) {
        if (val < 3 && subCounter === 0) result.push(val);
        else {
            if (subCounter === 0) subCounter = val;
            subCounter--;
            sub.push(val);
        }
        if (subCounter === 0 && sub.length) {
            result.push(sub);
            sub = [];
        }
    }
    if (sub.length) result.push(sub);
    return result;
}

///
const unflattenWithReduce = (flatArray) =>
    flatArray.reduce(
        (unflat, item, index, arr) => (
            item < 3
                ? unflat.push(item)
                : unflat.push(arr.splice(index, item, null)),
                unflat
        ),
        [],
    );

const unflattenWithReduceExplained = (flatArray) =>
    flatArray.reduce(
        // arr.reduce(callback(accumulator, currentValue[, index[, array]]), [, initialValue])
        (unflat, item, index, arr) => (
            (item < 3 ?
                unflat.push(item) :
                unflat.push(
                    // The splice() method changes the contents of an array by removing or replacing existing elements
                    // and/or adding new elements in place.
                    arr.splice(index, item, null)) // array.splice(start, deleteCount[, item1[, item2[, ...]]])
            ), // The comma operator evaluates each of its operands (from left to right)
               // and returns the value of the last operand.
               // Comma expressions are often a sign of overly clever code, and may lead to subtle bugs.
            unflat
        ),
        [],
    );

///
const unflattenShiftAndSplice = arr => {
    const result = [];
    while (arr.length) {
        result.push(arr[0] < 3 ?
            arr.shift() : // The shift() method removes the first element from an array and returns that removed element.
                          // This method changes the length of the array.
            arr.splice(0, arr[0]));
    }
    return result;
};