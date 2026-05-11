var separateDigits = function(nums) {
    const answer = [];
    for (const num of nums) {
        const digits = String(num).split('').map(Number);
        answer.push(...digits);
    }
    return answer;
};