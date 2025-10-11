/**
 * Time Complexity: O(n log k) - Where n is array length
 * Space Complexity: O(n) - For object and heap
 */
var topKFrequent = function(nums, k) {
    // Count frequency of each element
    const frequencyMap = {};
    for (const num of nums) {
        frequencyMap[num] = (frequencyMap[num] || 0) + 1;
    }
    
    // Convert to array and sort by frequency
    const entries = Object.entries(frequencyMap);
    entries.sort((a, b) => b[1] - a[1]);
    
    // Return top k elements
    return entries.slice(0, k).map(entry => parseInt(entry[0]));
};

// Alternative approach using bucket sort (most efficient)
var topKFrequentBucketSort = function(nums, k) {
    // Count frequency
    const frequencyMap = {};
    for (const num of nums) {
        frequencyMap[num] = (frequencyMap[num] || 0) + 1;
    }
    
    // Create buckets for each frequency
    const buckets = Array(nums.length + 1).fill(null).map(() => []);
    for (const [num, frequency] of Object.entries(frequencyMap)) {
        buckets[frequency].push(parseInt(num));
    }
    
    // Collect top k elements
    const result = [];
    for (let i = buckets.length - 1; i >= 0 && result.length < k; i--) {
        result.push(...buckets[i]);
    }
    
    return result.slice(0, k);
};

// Using Map for cleaner frequency counting
var topKFrequentMap = function(nums, k) {
    const frequencyMap = new Map();
    
    // Count frequency
    for (const num of nums) {
        frequencyMap.set(num, (frequencyMap.get(num) || 0) + 1);
    }
    
    // Sort by frequency and return top k
    return Array.from(frequencyMap.entries())
        .sort((a, b) => b[1] - a[1])
        .slice(0, k)
        .map(entry => entry[0]);
};
