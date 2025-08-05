/**
 * @param {number[]} fruits
 * @param {number[]} baskets
 * @return {number}
 */
var numOfUnplacedFruits = function(fruits, baskets) {
    const used = new Array(baskets.length).fill(false);
    let unplaced = 0;
    
    for (const fruit of fruits) {
        let placed = false;
        
        // Find the leftmost available basket with sufficient capacity
        for (let i = 0; i < baskets.length; i++) {
            if (!used[i] && baskets[i] >= fruit) {
                used[i] = true;  // Mark basket as used
                placed = true;
                break;
            }
        }
        
        if (!placed) {
            unplaced++;
        }
    }
    
    return unplaced;
}; 