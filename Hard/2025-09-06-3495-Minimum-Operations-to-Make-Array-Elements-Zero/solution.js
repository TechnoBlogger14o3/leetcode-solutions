var minOperations = function(queries) {
    const results = [];
    
    for (const [l, r] of queries) {
        let operations = 0;
        let nums = [];
        
        for (let i = l; i <= r; i++) {
            nums.push(i);
        }
        
        while (nums.length > 0) {
            nums.sort((a, b) => b - a);
            const a = nums.pop();
            const b = nums.pop() || 0;
            const newA = Math.floor(a / 4);
            const newB = Math.floor(b / 4);
            
            if (newA > 0) nums.push(newA);
            if (newB > 0) nums.push(newB);
            operations++;
        }
        
        results.push(operations);
    }
    
    return results.reduce((a, b) => a + b, 0);
};