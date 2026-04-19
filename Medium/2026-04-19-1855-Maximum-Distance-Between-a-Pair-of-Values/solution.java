class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (j < nums2.length && nums1[i] <= nums2[j]) {
                j++;
            }
            maxDist = Math.max(maxDist, j - 1 - i);
        }
        return maxDist;
    }
}