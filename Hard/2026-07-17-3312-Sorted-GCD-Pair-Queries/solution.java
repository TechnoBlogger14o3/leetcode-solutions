import java.util.*;

class Solution {
    public int[] sortedGcdPairs(int[] nums, int[] queries) {
        int n = nums.length;
        List<Integer> gcdPairs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                gcdPairs.add(gcd(nums[i], nums[j]));
            }
        }
        
        Collections.sort(gcdPairs);
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = gcdPairs.get(queries[i]);
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}