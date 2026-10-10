class Solution {
    public long minimumSum(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalDifference = 0;
        long[] differences = new long[n];
        
        for (int i = 0; i < n; i++) {
            differences[i] = Math.abs(nums1[i] - nums2[i]);
            totalDifference += differences[i] * differences[i];
        }
        
        long totalK = k1 + k2;
        Arrays.sort(differences);
        
        for (int i = n - 1; i >= 0 && totalK > 0; i--) {
            long diff = differences[i];
            if (diff == 0) break;
            long reduce = Math.min(diff, totalK);
            totalDifference -= diff * diff;
            diff -= reduce;
            totalDifference += diff * diff;
            totalK -= reduce;
        }
        
        return totalDifference;
    }
}