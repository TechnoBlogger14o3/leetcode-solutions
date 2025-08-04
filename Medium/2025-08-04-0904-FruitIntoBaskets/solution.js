/**
 * @param {number[]} fruits
 * @return {number}
 */
var totalFruit = function(fruits) {
    const basket = new Map();
    let left = 0;
    let maxFruits = 0;
    
    for (let right = 0; right < fruits.length; right++) {
        basket.set(fruits[right], (basket.get(fruits[right]) || 0) + 1);
        
        // Shrink window if we have more than 2 types
        while (basket.size > 2) {
            basket.set(fruits[left], basket.get(fruits[left]) - 1);
            if (basket.get(fruits[left]) === 0) {
                basket.delete(fruits[left]);
            }
            left++;
        }
        
        maxFruits = Math.max(maxFruits, right - left + 1);
    }
    
    return maxFruits;
}; 