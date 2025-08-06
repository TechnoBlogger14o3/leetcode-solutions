/**
 * @param {number[]} fruits
 * @param {number[]} baskets
 * @return {number}
 */
var numOfUnplacedFruits = function(fruits, baskets) {
    let minUnplaced = Infinity;
    
    // Try placing all fruits without skipping
    minUnplaced = Math.min(minUnplaced, placeFruitsOptimized(fruits, baskets, -1));
    
    // Try skipping each fruit type
    for (let skipIndex = 0; skipIndex < fruits.length; skipIndex++) {
        minUnplaced = Math.min(minUnplaced, placeFruitsOptimized(fruits, baskets, skipIndex));
    }
    
    return minUnplaced;
};

function placeFruitsOptimized(fruits, baskets, skipIndex) {
    // Use sorted array to maintain available baskets efficiently
    const availableBaskets = [...baskets].sort((a, b) => a - b);
    let unplaced = 0;
    
    for (let i = 0; i < fruits.length; i++) {
        if (i === skipIndex) {
            unplaced++; // Count skipped fruit as unplaced
            continue;
        }
        
        // Find the smallest available basket that can hold this fruit
        let basketIndex = -1;
        for (let j = 0; j < availableBaskets.length; j++) {
            if (availableBaskets[j] >= fruits[i]) {
                basketIndex = j;
                break;
            }
        }
        
        if (basketIndex === -1) {
            unplaced++;
        } else {
            availableBaskets.splice(basketIndex, 1); // Remove used basket
        }
    }
    
    return unplaced;
} 