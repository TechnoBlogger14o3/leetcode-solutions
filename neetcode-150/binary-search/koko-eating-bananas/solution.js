/**
 * Time Complexity: O(n * log(max(piles))) - Binary search + validation
 * Space Complexity: O(1) - Only uses constant extra space
 */
var minEatingSpeed = function(piles, h) {
    let left = 1;
    let right = Math.max(...piles);
    
    while (left < right) {
        const mid = Math.floor(left + (right - left) / 2);
        
        if (canFinish(piles, mid, h)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return left;
};

function canFinish(piles, speed, h) {
    let totalHours = 0;
    
    for (const pile of piles) {
        totalHours += Math.ceil(pile / speed);
    }
    
    return totalHours <= h;
}

// Alternative approach using reduce
var minEatingSpeedReduce = function(piles, h) {
    let left = 1;
    let right = Math.max(...piles);
    
    while (left < right) {
        const mid = Math.floor(left + (right - left) / 2);
        
        if (canFinishReduce(piles, mid, h)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return left;
};

function canFinishReduce(piles, speed, h) {
    return piles.reduce((total, pile) => total + Math.ceil(pile / speed), 0) <= h;
}

// More concise version
var minEatingSpeedConcise = function(piles, h) {
    let left = 1, right = Math.max(...piles);
    
    while (left < right) {
        const mid = Math.floor(left + (right - left) / 2);
        if (piles.reduce((total, pile) => total + Math.ceil(pile / mid), 0) <= h) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return left;
};

// Using arrow functions
var minEatingSpeedArrow = function(piles, h) {
    const canFinish = (speed) => piles.reduce((total, pile) => total + Math.ceil(pile / speed), 0) <= h;
    
    let left = 1, right = Math.max(...piles);
    
    while (left < right) {
        const mid = Math.floor(left + (right - left) / 2);
        if (canFinish(mid)) right = mid;
        else left = mid + 1;
    }
    
    return left;
};

// Using bit manipulation for mid calculation
var minEatingSpeedBitManipulation = function(piles, h) {
    let left = 1;
    let right = Math.max(...piles);
    
    while (left < right) {
        const mid = (left + right) >>> 1; // Unsigned right shift
        
        if (canFinish(piles, mid, h)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return left;
};
