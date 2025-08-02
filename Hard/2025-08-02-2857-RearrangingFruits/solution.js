/**
 * @param {number[]} basket1
 * @param {number[]} basket2
 * @return {number}
 */
var minCost = function(basket1, basket2) {
    // Check if sums are equal
    const sum1 = basket1.reduce((sum, fruit) => sum + fruit, 0);
    const sum2 = basket2.reduce((sum, fruit) => sum + fruit, 0);
    
    if (sum1 !== sum2) return -1;
    
    // Count frequencies
    const freq1 = new Map();
    const freq2 = new Map();
    
    for (const fruit of basket1) {
        freq1.set(fruit, (freq1.get(fruit) || 0) + 1);
    }
    for (const fruit of basket2) {
        freq2.set(fruit, (freq2.get(fruit) || 0) + 1);
    }
    
    // Check if each fruit type has even total count
    const allFruits = new Set([...freq1.keys(), ...freq2.keys()]);
    
    for (const fruit of allFruits) {
        const total = (freq1.get(fruit) || 0) + (freq2.get(fruit) || 0);
        if (total % 2 !== 0) return -1;
    }
    
    // Calculate excess/deficit
    const excess = [];
    const deficit = [];
    
    for (const fruit of allFruits) {
        const count1 = freq1.get(fruit) || 0;
        const count2 = freq2.get(fruit) || 0;
        const target = (count1 + count2) / 2;
        
        if (count1 > target) {
            for (let i = 0; i < count1 - target; i++) {
                excess.push(fruit);
            }
        } else if (count2 > target) {
            for (let i = 0; i < count2 - target; i++) {
                deficit.push(fruit);
            }
        }
    }
    
    // Sort for optimal matching
    excess.sort((a, b) => a - b);
    deficit.sort((a, b) => a - b);
    
    let cost = 0;
    for (let i = 0; i < excess.length; i++) {
        cost += Math.min(excess[i], deficit[i]);
    }
    
    return cost;
}; 