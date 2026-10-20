class Solution {
    public int sortableIntegersSum(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k == 0) {
                if (isSortable(nums, k)) {
                    sum += k;
                }
            }
        }

        return sum;
    }

    private boolean isSortable(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int start = 0; start < n; start += k) {
            int[] subarray = Arrays.copyOfRange(nums, start, Math.min(start + k, n));
            Arrays.sort(subarray);
            for (int i = 0; i < subarray.length; i++) {
                if (subarray[i] != sorted[start + i]) {
                    return false;
                }
            }
        }

        return true;
    }
}