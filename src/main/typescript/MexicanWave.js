function wave(text) {
    return Array.from(Array(text.length).keys())
        .map(() => text)
        .map(mexicanize)
        .filter(hasCapitalLetter)
}

const capitalLetterMatcher = new RegExp("[A-Z]");
function hasCapitalLetter(text) {
    return text.match(capitalLetterMatcher);
}

function mexicanize(text, index) {
    return text.substring(0, index) + text.charAt(index).toUpperCase() + text.substring(index + 1);
}
