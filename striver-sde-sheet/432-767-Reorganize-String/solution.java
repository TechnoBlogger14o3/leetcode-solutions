import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        heap.addAll(count.keySet());
        
        if (count.get(heap.peek()) > (s.length() + 1) / 2) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        Character prev = null;
        
        while (!heap.isEmpty() || prev != null) {
            if (heap.isEmpty() && prev != null) {
                return "";
            }
            
            char curr = heap.poll();
            result.append(curr);
            count.put(curr, count.get(curr) - 1);
            
            if (prev != null) {
                heap.offer(prev);
                prev = null;
            }
            
            if (count.get(curr) > 0) {
                prev = curr;
            }
        }
        
        return result.toString();
    }
}
