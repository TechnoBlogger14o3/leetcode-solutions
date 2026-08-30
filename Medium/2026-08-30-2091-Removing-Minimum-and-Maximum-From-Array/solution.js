var minimumDeletions = function(nums) {
    const minIndex = nums.indexOf(Math.min(...nums));
    const maxIndex = nums.indexOf(Math.max(...nums));
    const n = nums.length;

    const frontDeletions = Math.max(minIndex, maxIndex) + 1;
    const backDeletions = n - Math.min(minIndex, maxIndex);
    const bothEndsDeletions = minIndex + 1 + (n - maxIndex);

    return Math.min(frontDeletions, backDeletions, bothEndsDeletions);
};