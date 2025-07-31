/**
 * @param {number[]} arr
 * @return {number}
 */
var subarrayBitwiseORs = function(arr) {
    const result = new Set();
    let current = new Set();
    
    for (const num of arr) {
        const next = new Set();
        next.add(num);
        
        for (const val of current) {
            next.add(val | num);
        }
        
        for (const val of next) {
            result.add(val);
        }
        
        current = next;
    }
    
    return result.size();
}; 