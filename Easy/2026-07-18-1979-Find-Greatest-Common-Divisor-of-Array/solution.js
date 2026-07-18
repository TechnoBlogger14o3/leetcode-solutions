var findGCD = function(nums) {
    const minNum = Math.min(...nums);
    const maxNum = Math.max(...nums);
    
    function gcd(a, b) {
        while (b) {
            [a, b] = [b, a % b];
        }
        return a;
    }
    
    return gcd(minNum, maxNum);
};