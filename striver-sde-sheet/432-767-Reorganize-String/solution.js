/**
 * @param {string} s
 * @return {string}
 */
var reorganizeString = function(s) {
    const count = {};
    for (let char of s) {
        count[char] = (count[char] || 0) + 1;
    }
    
    const maxCount = Math.max(...Object.values(count));
    if (maxCount > Math.floor((s.length + 1) / 2)) {
        return "";
    }
    
    const sorted = Object.keys(count).sort((a, b) => count[b] - count[a]);
    const result = [];
    let prev = null;
    
    while (sorted.length > 0 || prev) {
        if (sorted.length === 0 && prev) {
            return "";
        }
        
        const curr = sorted[0];
        result.push(curr);
        count[curr]--;
        
        if (count[curr] === 0) {
            sorted.shift();
        } else {
            sorted.sort((a, b) => count[b] - count[a]);
        }
        
        if (prev) {
            sorted.push(prev);
            sorted.sort((a, b) => count[b] - count[a]);
            prev = null;
        }
        
        if (count[curr] > 0) {
            prev = curr;
        }
    }
    
    return result.join("");
};
