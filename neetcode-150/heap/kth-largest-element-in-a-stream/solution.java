/**
 * Time Complexity: O(log k) for add operation
 * Space Complexity: O(k) - Heap size
 */
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        
        // Add initial elements
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        
        return minHeap.peek();
    }
}

// Alternative approach using max heap
class KthLargestMaxHeap {
    private PriorityQueue<Integer> maxHeap;
    private int k;
    
    public KthLargestMaxHeap(int k, int[] nums) {
        this.k = k;
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
            maxHeap.offer(num);
        }
    }
    
    public int add(int val) {
        maxHeap.offer(val);
        
        // Keep only k largest elements
        while (maxHeap.size() > k) {
            maxHeap.poll();
        }
        
        return maxHeap.peek();
    }
}

// Alternative approach using TreeSet
class KthLargestTreeSet {
    private TreeSet<Integer> treeSet;
    private int k;
    
    public KthLargestTreeSet(int k, int[] nums) {
        this.k = k;
        this.treeSet = new TreeSet<>();
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        treeSet.add(val);
        
        if (treeSet.size() > k) {
            treeSet.pollFirst();
        }
        
        return treeSet.first();
    }
}

// Alternative approach using ArrayList with sorting
class KthLargestArrayList {
    private List<Integer> list;
    private int k;
    
    public KthLargestArrayList(int k, int[] nums) {
        this.k = k;
        this.list = new ArrayList<>();
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        
        if (list.size() > k) {
            list.remove(0);
        }
        
        return list.get(0);
    }
}

// More concise version
class KthLargestConcise {
    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    private int k;
    
    public KthLargestConcise(int k, int[] nums) {
        this.k = k;
        for (int num : nums) add(num);
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }
}

// Using custom comparator
class KthLargestCustom {
    private PriorityQueue<Integer> minHeap;
    private int k;
    
    public KthLargestCustom(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        
        return minHeap.peek();
    }
}
