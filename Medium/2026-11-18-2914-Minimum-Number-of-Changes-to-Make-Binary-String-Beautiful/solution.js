var minimumChanges = function(s) {
    let changes = 0;
    for (let i = 0; i < s.length; i += 2) {
        const count0 = (s[i] === '0' ? 1 : 0) + (s[i + 1] === '0' ? 1 : 0);
        const count1 = (s[i] === '1' ? 1 : 0) + (s[i + 1] === '1' ? 1 : 0);
        changes += Math.min(count0, count1);
    }
    return changes;
};