/**
 * @param {number[]} fruits
 * @param {number[]} baskets
 * @return {number}
 */
var numOfUnplacedFruits = function(fruits, baskets) {
    let minUnplaced = Infinity;
    
    // Try placing all fruits without skipping
    minUnplaced = Math.min(minUnplaced, placeFruits(fruits, baskets, -1));
    
    // Try skipping each fruit type
    for (let skipIndex = 0; skipIndex < fruits.length; skipIndex++) {
        minUnplaced = Math.min(minUnplaced, placeFruits(fruits, baskets, skipIndex));
    }
    
    return minUnplaced;
};

function placeFruits(fruits, baskets, skipIndex) {
    const used = new Array(baskets.length).fill(false);
    let unplaced = 0;
    
    for (let i = 0; i < fruits.length; i++) {
        if (i === skipIndex) continue; // Skip this fruit
        
        let placed = false;
        
        // Find the leftmost available basket with sufficient capacity
        for (let j = 0; j < baskets.length; j++) {
            if (!used[j] && baskets[j] >= fruits[i]) {
                used[j] = true;  // Mark basket as used
                placed = true;
                break;
            }
        }
        
        if (!placed) {
            unplaced++;
        }
    }
    
    return unplaced;
} 