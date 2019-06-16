/**
 * @return {string}
 */
function SeriesSum(n) {
    return Array.from(Array(n).keys())
    .map(i => 3 * i + 1)
    .reduce((acc, v) => acc + 1 / v, 0)
    .toFixed(2)
    .toString();
}



function SeriesSum(n) {
    for (var s = 0, i = 0; i < n; i++) {
        s += 1 / (1 + i * 3)
    }

    return s.toFixed(2)
}
