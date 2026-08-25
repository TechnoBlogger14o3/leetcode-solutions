import java.util.HashSet;

class Solution {
    public int findSmallestInteger(int[] nums, int k) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int multiple = k;
        while (numSet.contains(multiple)) {
            multiple += k;
        }
        
        return multiple;
    }
}