/**
 * Time Complexity: O(m) - m is total time units
 * Space Complexity: O(1) - At most 26 tasks
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }
        
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            
            // Process n+1 tasks in one cycle
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    if (freq > 1) {
                        temp.add(freq - 1);
                    }
                }
                time++;
                
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }
            
            // Add tasks back to heap
            for (int f : temp) {
                maxHeap.offer(f);
            }
        }
        
        return time;
    }
}

// Alternative approach using mathematical formula
class SolutionMath {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        int maxFreq = 0;
        int maxCount = 0;
        
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
                maxCount = 1;
            } else if (f == maxFreq) {
                maxCount++;
            }
        }
        
        int idleSlots = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(idleSlots, tasks.length);
    }
}

// Alternative approach using queue
class SolutionQueue {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            
            if (!maxHeap.isEmpty()) {
                int freq = maxHeap.poll();
                if (freq > 1) {
                    queue.offer(new int[]{freq - 1, time + n});
                }
            }
            
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }
        
        return time;
    }
}

// Alternative approach using simulation
class SolutionSimulation {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }
        
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    if (freq > 1) {
                        temp.add(freq - 1);
                    }
                }
                time++;
                
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }
            
            for (int f : temp) {
                maxHeap.offer(f);
            }
        }
        
        return time;
    }
}

// More concise version
class SolutionConcise {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) freq[task - 'A']++;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) if (f > 0) heap.offer(f);
        
        int time = 0;
        while (!heap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i <= n; i++) {
                if (!heap.isEmpty()) {
                    int f = heap.poll();
                    if (f > 1) temp.add(f - 1);
                }
                time++;
                if (heap.isEmpty() && temp.isEmpty()) break;
            }
            
            for (int f : temp) heap.offer(f);
        }
        
        return time;
    }
}

// Using custom comparator
class SolutionCustom {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(26, (a, b) -> b - a);
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }
        
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    if (freq > 1) {
                        temp.add(freq - 1);
                    }
                }
                time++;
                
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }
            
            for (int f : temp) {
                maxHeap.offer(f);
            }
        }
        
        return time;
    }
}
