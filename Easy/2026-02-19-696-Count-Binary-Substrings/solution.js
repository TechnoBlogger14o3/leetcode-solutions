var countBinarySubstrings = function(s) {
    let groups = [1];
    for (let i = 1; i < s.length; i++) {
        if (s[i] === s[i - 1]) {
            groups[groups.length - 1]++;
        } else {
            groups.push(1);
        }
    }
    
    let count = 0;
    for (let i = 1; i < groups.length; i++) {
        count += Math.min(groups[i - 1], groups[i]);
    }
    
    return count;
};