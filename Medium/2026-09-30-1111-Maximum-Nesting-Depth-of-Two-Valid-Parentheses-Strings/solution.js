var maxDepthAfterSplit = function(seq) {
    const result = new Array(seq.length);
    let depth = 0;

    for (let i = 0; i < seq.length; i++) {
        if (seq[i] === '(') {
            depth++;
            result[i] = depth % 2; // 0 for A, 1 for B
        } else {
            result[i] = (depth - 1) % 2; // 0 for A, 1 for B
            depth--;
        }
    }

    return result;
};