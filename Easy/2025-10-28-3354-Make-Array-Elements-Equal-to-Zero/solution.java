class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int validCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (canMakeAllZero(nums, i, 1) || canMakeAllZero(nums, i, -1)) {
                    validCount++;
                }
            }
        }

        return validCount;
    }

    private boolean canMakeAllZero(int[] nums, int start, int direction) {
        int[] copy = nums.clone();
        int curr = start;

        while (curr >= 0 && curr < copy.length) {
            if (copy[curr] == 0) {
                curr += direction;
            } else {
                copy[curr]--;
                direction = -direction; // reverse direction
                curr += direction;
            }
        }

        for (int num : copy) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}