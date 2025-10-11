"""
Time Complexity: O(n log k) - Where n is array length
Space Complexity: O(n) - For dictionary and heap
"""
import heapq
from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Count frequency of each element
        frequency_map = Counter(nums)
        
        # Use min-heap to keep top k frequent elements
        min_heap = []
        
        for num, frequency in frequency_map.items():
            heapq.heappush(min_heap, (frequency, num))
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        # Extract results
        return [num for frequency, num in min_heap]

# Alternative approach using bucket sort (most efficient)
class SolutionBucketSort:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Count frequency
        frequency_map = Counter(nums)
        
        # Create buckets for each frequency
        buckets = [[] for _ in range(len(nums) + 1)]
        for num, frequency in frequency_map.items():
            buckets[frequency].append(num)
        
        # Collect top k elements
        result = []
        for i in range(len(buckets) - 1, -1, -1):
            result.extend(buckets[i])
            if len(result) >= k:
                break
        
        return result[:k]

# Sorting approach
class SolutionSorting:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequency_map = Counter(nums)
        
        # Sort by frequency in descending order
        sorted_items = sorted(frequency_map.items(), key=lambda x: x[1], reverse=True)
        
        # Return top k elements
        return [num for num, frequency in sorted_items[:k]]

# Using most_common method
class SolutionMostCommon:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return [num for num, frequency in Counter(nums).most_common(k)]
