var minimumOperations = function(nums) {
    const n = nums.length;
    let sorted = [...nums].sort((a, b) => a - b);
    
    if (JSON.stringify(nums) === JSON.stringify(sorted)) return 0;

    let count = 0;
    let visited = new Array(n).fill(false);

    for (let i = 0; i < n; i++) {
        if (visited[i] || nums[i] === sorted[i]) continue;

        let cycleSize = 0;
        let j = i;

        while (!visited[j]) {
            visited[j] = true;
            j = nums.indexOf(sorted[j]);
            cycleSize++;
        }

        if (cycleSize > 0) {
            count += (cycleSize - 1);
        }
    }

    return count > 0 ? count + 1 : -1;
};