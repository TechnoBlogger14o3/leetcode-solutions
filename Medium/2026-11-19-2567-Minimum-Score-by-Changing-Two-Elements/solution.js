var minimumScore = function(nums) {
    const minNum = Math.min(...nums);
    const maxNum = Math.max(...nums);
    
    if (nums.length <= 2) return 0;

    const lowScore = Math.min(maxNum - minNum, 0);
    const highScore = maxNum - minNum;

    return highScore + lowScore;
};