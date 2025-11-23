var maxSumDivThree = function(nums) {
    let sum = 0;
    let mod = [0, Infinity, Infinity];
    
    for (let num of nums) {
        sum += num;
        let newMod = [...mod];
        
        for (let i = 0; i < 3; i++) {
            newMod[(i + num) % 3] = Math.min(newMod[(i + num) % 3], mod[i] + num);
        }
        
        mod = newMod;
    }
    
    return sum - mod[1] === Infinity ? sum : sum - mod[1];
};