/**
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(1) - Only using two variables
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // Update minimum price seen so far
            minPrice = Math.min(minPrice, prices[i]);
            
            // Calculate profit if we sell today
            int profit = prices[i] - minPrice;
            
            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }
}

// Alternative approach using brute force
class SolutionBruteForce {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        
        return maxProfit;
    }
}

// More concise version
class SolutionConcise {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
    }
}

// Using streams for functional approach
class SolutionStreams {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int minPrice = prices[0];
        return Arrays.stream(prices)
                .skip(1)
                .map(price -> {
                    minPrice = Math.min(minPrice, price);
                    return price - minPrice;
                })
                .max()
                .orElse(0);
    }
}
