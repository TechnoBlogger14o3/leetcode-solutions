var minimumPushes = function(word) {
    const n = word.length;
    // The minimum pushes needed is the sum of the first n natural numbers
    return (n * (n + 1)) / 2;
};