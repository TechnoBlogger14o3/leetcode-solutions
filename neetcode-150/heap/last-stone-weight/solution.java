/**
 * Time Complexity: O(n log n) - n operations, each O(log n)
 * Space Complexity: O(n) - Heap size
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all stones to max heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        // Smash stones until at most one remains
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}

// Alternative approach using sorting
class SolutionSorting {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        
        while (list.size() > 1) {
            Collections.sort(list, Collections.reverseOrder());
            
            int stone1 = list.remove(0);
            int stone2 = list.remove(0);
            
            if (stone1 != stone2) {
                list.add(stone1 - stone2);
            }
        }
        
        return list.isEmpty() ? 0 : list.get(0);
    }
}

// Alternative approach using TreeSet
class SolutionTreeSet {
    public int lastStoneWeight(int[] stones) {
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        
        for (int stone : stones) {
            treeSet.add(stone);
        }
        
        while (treeSet.size() > 1) {
            int stone1 = treeSet.pollFirst();
            int stone2 = treeSet.pollFirst();
            
            if (stone1 != stone2) {
                treeSet.add(stone1 - stone2);
            }
        }
        
        return treeSet.isEmpty() ? 0 : treeSet.first();
    }
}

// Alternative approach using custom comparator
class SolutionCustom {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, (a, b) -> b - a);
        
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}

// More concise version
class SolutionConcise {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) heap.offer(stone);
        
        while (heap.size() > 1) {
            int diff = heap.poll() - heap.poll();
            if (diff > 0) heap.offer(diff);
        }
        
        return heap.isEmpty() ? 0 : heap.poll();
    }
}

// Using array simulation
class SolutionArray {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        
        while (n > 1) {
            // Find two largest stones
            int max1 = 0, max2 = 1;
            if (stones[max1] < stones[max2]) {
                int temp = max1;
                max1 = max2;
                max2 = temp;
            }
            
            for (int i = 2; i < n; i++) {
                if (stones[i] > stones[max1]) {
                    max2 = max1;
                    max1 = i;
                } else if (stones[i] > stones[max2]) {
                    max2 = i;
                }
            }
            
            // Smash stones
            if (stones[max1] != stones[max2]) {
                stones[max1] = stones[max1] - stones[max2];
                stones[max2] = stones[n - 1];
                n--;
            } else {
                stones[max1] = stones[n - 1];
                stones[max2] = stones[n - 2];
                n -= 2;
            }
        }
        
        return n == 1 ? stones[0] : 0;
    }
}
