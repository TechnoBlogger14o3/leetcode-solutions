var successfulPairs = function(spells, potions, success) {
    potions.sort((a, b) => a - b);
    const m = potions.length;
    const result = new Array(spells.length);
    
    for (let i = 0; i < spells.length; i++) {
        const spell = spells[i];
        const requiredPotionStrength = Math.ceil(success / spell);
        let left = 0, right = m - 1;
        
        while (left <= right) {
            const mid = Math.floor((left + right) / 2);
            if (potions[mid] >= requiredPotionStrength) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        result[i] = m - left;
    }
    
    return result;
};