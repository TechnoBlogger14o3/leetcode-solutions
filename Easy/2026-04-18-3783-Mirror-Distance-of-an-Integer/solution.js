var mirrorDistance = function(n) {
    const reverseN = parseInt(n.toString().split('').reverse().join(''), 10);
    return Math.abs(n - reverseN);
};