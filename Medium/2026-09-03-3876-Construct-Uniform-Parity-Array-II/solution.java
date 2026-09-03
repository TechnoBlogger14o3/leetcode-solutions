class Solution {
    public boolean canConstructArray(int[] nums1) {
        int oddCount = 0;
        int evenCount = 0;
        
        for (int num : nums1) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        return oddCount == 0 || evenCount == 0 || (oddCount > 0 && evenCount > 0 && Math.abs(oddCount - evenCount) > 1);
    }
}