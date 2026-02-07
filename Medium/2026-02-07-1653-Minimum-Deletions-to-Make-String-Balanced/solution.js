var minimumDeletions = function(s) {
    let bCount = 0;
    let deletions = 0;

    for (let char of s) {
        if (char === 'b') {
            bCount++;
        } else {
            deletions += bCount;
        }
    }

    return deletions;
};