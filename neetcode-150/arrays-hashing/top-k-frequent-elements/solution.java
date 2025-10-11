import java.util.*;

/**
 * Time Complexity: O(n log k) - Where n is array length
 * Space Complexity: O(n) - For HashMap and heap
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Use min-heap to keep top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Extract results
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        
        return result;
    }
}

// Alternative approach using bucket sort (most efficient)
class SolutionBucketSort {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create buckets for each frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }
        
        // Collect top k elements
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}

// Sorting approach
class SolutionSorting {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
        
        return result;
    }
}
