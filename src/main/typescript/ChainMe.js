function chain(input, fs) {
    let output = input;
    for (const fun of fs) {
        output = fun(output);
    }
    return output;
}

function chain(v, fns) {
    return fns.reduce(function(v, fn) { return fn(v) }, v);
}
