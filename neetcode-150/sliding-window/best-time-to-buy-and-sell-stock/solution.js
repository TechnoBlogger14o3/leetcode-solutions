/**
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(1) - Only using two variables
 */
var maxProfit = function(prices) {
    if (prices.length === 0) return 0;
    
    let minPrice = prices[0];
    let maxProfit = 0;
    
    for (let i = 1; i < prices.length; i++) {
        // Update minimum price seen so far
        minPrice = Math.min(minPrice, prices[i]);
        
        // Calculate profit if we sell today
        const profit = prices[i] - minPrice;
        
        // Update maximum profit
        maxProfit = Math.max(maxProfit, profit);
    }
    
    return maxProfit;
};

// Alternative approach using brute force
var maxProfitBruteForce = function(prices) {
    let maxProfit = 0;
    
    for (let i = 0; i < prices.length; i++) {
        for (let j = i + 1; j < prices.length; j++) {
            const profit = prices[j] - prices[i];
            maxProfit = Math.max(maxProfit, profit);
        }
    }
    
    return maxProfit;
};

// More concise version
var maxProfitConcise = function(prices) {
    let minPrice = Infinity;
    let maxProfit = 0;
    
    for (const price of prices) {
        minPrice = Math.min(minPrice, price);
        maxProfit = Math.max(maxProfit, price - minPrice);
    }
    
    return maxProfit;
};

// Using reduce for functional approach
var maxProfitFunctional = function(prices) {
    if (prices.length === 0) return 0;
    
    let minPrice = prices[0];
    return prices.slice(1).reduce((maxProfit, price) => {
        minPrice = Math.min(minPrice, price);
        return Math.max(maxProfit, price - minPrice);
    }, 0);
};
