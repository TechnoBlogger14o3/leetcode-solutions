var closestEqualElementQueries = function(nums, queries) {
    const n = nums.length;
    const indexMap = new Map();
    const answer = new Array(queries.length).fill(-1);
    
    for (let i = 0; i < n; i++) {
        if (!indexMap.has(nums[i])) {
            indexMap.set(nums[i], []);
        }
        indexMap.get(nums[i]).push(i);
    }
    
    for (let i = 0; i < queries.length; i++) {
        const queryIndex = queries[i];
        const value = nums[queryIndex];
        const indices = indexMap.get(value);
        
        if (indices.length <= 1) continue;
        
        let minDistance = Infinity;
        for (const index of indices) {
            if (index !== queryIndex) {
                const distance = Math.abs(index - queryIndex);
                const circularDistance = n - distance;
                minDistance = Math.min(minDistance, Math.min(distance, circularDistance));
            }
        }
        
        answer[i] = minDistance === Infinity ? -1 : minDistance;
    }
    
    return answer;
};