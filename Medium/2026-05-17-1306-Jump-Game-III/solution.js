var canReach = function(arr, start) {
    const n = arr.length;
    const visited = new Set();
    
    const dfs = (index) => {
        if (index < 0 || index >= n || visited.has(index)) return false;
        if (arr[index] === 0) return true;
        
        visited.add(index);
        
        return dfs(index + arr[index]) || dfs(index - arr[index]);
    };
    
    return dfs(start);
};