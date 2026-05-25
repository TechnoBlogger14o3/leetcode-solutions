var canReach = function(s, minJump, maxJump) {
    const n = s.length;
    if (s[n - 1] !== '0') return false;

    let farthest = 0, current = 0;
    for (let i = 0; i < n; i++) {
        if (i > farthest) return false;
        if (s[i] === '0') {
            if (i >= minJump) {
                current = Math.max(current, i + minJump);
            }
            if (i <= farthest + maxJump) {
                farthest = Math.max(farthest, i + maxJump);
            }
        }
    }
    return farthest >= n - 1;
};