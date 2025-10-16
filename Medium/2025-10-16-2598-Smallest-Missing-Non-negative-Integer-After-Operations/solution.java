import java.util.HashSet;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashSet<Integer> reachable = new HashSet<>();
        
        for (int num : nums) {
            int start = num % value;
            if (start < 0) start += value;
            for (int i = 0; i < value; i++) {
                reachable.add(start + i * value);
            }
        }
        
        int mex = 0;
        while (reachable.contains(mex)) {
            mex++;
        }
        
        return mex;
    }
}