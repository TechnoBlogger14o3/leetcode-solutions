function minimumSwaps(nums) {
    const digitSum = (num) => num.toString().split('').reduce((sum, digit) => sum + Number(digit), 0);
    
    const indexedNums = nums.map((num, index) => ({
        value: num,
        index: index,
        digitSum: digitSum(num)
    }));
    
    indexedNums.sort((a, b) => {
        if (a.digitSum === b.digitSum) {
            return a.value - b.value;
        }
        return a.digitSum - b.digitSum;
    });
    
    const visited = new Array(nums.length).fill(false);
    let swaps = 0;
    
    for (let i = 0; i < indexedNums.length; i++) {
        if (visited[i] || indexedNums[i].index === i) {
            continue;
        }
        
        let cycleSize = 0;
        let j = i;
        
        while (!visited[j]) {
            visited[j] = true;
            j = indexedNums[j].index;
            cycleSize++;
        }
        
        if (cycleSize > 0) {
            swaps += (cycleSize - 1);
        }
    }
    
    return swaps;
}