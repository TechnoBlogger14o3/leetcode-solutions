class PalindromicPathQueries {
    constructor(n, edges, s) {
        this.n = n;
        this.edges = edges;
        this.s = s.split('');
        this.graph = Array.from({ length: n }, () => []);
        this.parent = Array(n).fill(-1);
        this.depth = Array(n).fill(0);
        this.size = Array(n).fill(0);
        this.visited = Array(n).fill(false);
        this.path = [];
        
        for (const [u, v] of edges) {
            this.graph[u].push(v);
            this.graph[v].push(u);
        }
        
        this.dfs(0, -1, 0);
    }

    dfs(node, par, dep) {
        this.parent[node] = par;
        this.depth[node] = dep;
        this.size[node] = 1;
        this.visited[node] = true;
        this.path.push(node);
        
        for (const neighbor of this.graph[node]) {
            if (!this.visited[neighbor]) {
                this.size[node] += this.dfs(neighbor, node, dep + 1);
            }
        }
        
        return this.size[node];
    }

    findLCA(u, v) {
        while (u !== v) {
            if (this.depth[u] > this.depth[v]) {
                u = this.parent[u];
            } else {
                v = this.parent[v];
            }
        }
        return u;
    }

    canFormPalindrome(path) {
        const count = {};
        for (const char of path) {
            count[char] = (count[char] || 0) + 1;
        }
        let oddCount = 0;
        for (const c in count) {
            if (count[c] % 2 !== 0) oddCount++;
        }
        return oddCount <= 1;
    }

    processQueries(queries) {
        const result = [];
        
        for (const query of queries) {
            const parts = query.split(' ');
            if (parts[0] === 'update') {
                const u = parseInt(parts[1]);
                const c = parts[3];
                this.s[u] = c;
            } else if (parts[0] === 'query') {
                const u = parseInt(parts[1]);
                const v = parseInt(parts[2]);
                const lca = this.findLCA(u, v);
                const pathChars = [];
                
                const collectPath = (node) => {
                    while (node !== -1) {
                        pathChars.push(this.s[node]);
                        node = this.parent[node];
                    }
                };
                
                collectPath(u);
                collectPath(v);
                collectPath(lca);
                
                const path = pathChars.filter((char, index) => pathChars.indexOf(char) === index);
                result.push(this.canFormPalindrome(path));
            }
        }
        
        return result;
    }
}

function palindromicPathQueries(n, edges, s, queries) {
    const ppq = new PalindromicPathQueries(n, edges, s);
    return ppq.processQueries(queries);
}