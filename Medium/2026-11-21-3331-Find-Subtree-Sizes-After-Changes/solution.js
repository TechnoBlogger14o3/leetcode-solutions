var findSubtreeSizes = function(parent, s) {
    const n = parent.length;
    const tree = Array.from({ length: n }, () => []);
    const sizes = new Array(n).fill(1);
    
    for (let i = 1; i < n; i++) {
        tree[parent[i]].push(i);
    }
    
    const newParent = Array.from({ length: n }, () => -1);
    
    for (let x = 1; x < n; x++) {
        let y = x;
        while (y !== -1 && s[y] !== s[x]) {
            y = parent[y];
        }
        if (y !== -1) {
            newParent[x] = y;
        } else {
            newParent[x] = parent[x];
        }
    }
    
    const finalTree = Array.from({ length: n }, () => []);
    
    for (let i = 1; i < n; i++) {
        finalTree[newParent[i]].push(i);
    }
    
    const dfs = (node) => {
        for (const child of finalTree[node]) {
            sizes[node] += dfs(child);
        }
        return sizes[node];
    };
    
    dfs(0);
    
    return sizes;
};