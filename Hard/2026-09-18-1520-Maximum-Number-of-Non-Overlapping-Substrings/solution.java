import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (first[c - 'a'] == 0) {
                first[c - 'a'] = i + 1; // Store 1-based index
            }
            last[c - 'a'] = i + 1; // Store 1-based index
        }
        
        List<int[]> intervals = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            if (first[i] > 0) {
                int start = first[i] - 1;
                int end = last[i] - 1;
                for (int j = start; j <= end; j++) {
                    end = Math.max(end, last[s.charAt(j) - 'a'] - 1);
                }
                intervals.add(new int[]{start, end});
            }
        }
        
        intervals.sort((a, b) -> a[1] - b[1]);
        
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        
        for (int[] interval : intervals) {
            if (interval[0] > prevEnd) {
                result.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }
        
        return result;
    }
}