/**
 * Time Complexity: O(n log k) - n elements, heap size k
 * Space Complexity: O(k) - Heap size
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        
        return minHeap.peek();
    }
}

// Alternative approach using quick select
class SolutionQuickSelect {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        
        int pivot = partition(nums, left, right);
        
        if (pivot == k) {
            return nums[pivot];
        } else if (pivot < k) {
            return quickSelect(nums, pivot + 1, right, k);
        } else {
            return quickSelect(nums, left, pivot - 1, k);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        
        swap(nums, i, right);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Alternative approach using sorting
class SolutionSorting {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// Alternative approach using max heap
class SolutionMaxHeap {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
            maxHeap.offer(num);
        }
        
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        
        return maxHeap.poll();
    }
}

// Alternative approach using TreeSet
class SolutionTreeSet {
    public int findKthLargest(int[] nums, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        
        for (int num : nums) {
            treeSet.add(num);
        }
        
        int count = 0;
        for (int num : treeSet) {
            count++;
            if (count == k) {
                return num;
            }
        }
        
        return -1;
    }
}

// More concise version
class SolutionConcise {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }
        
        return heap.peek();
    }
}

// Using custom comparator
class SolutionCustom {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        
        return minHeap.peek();
    }
}
