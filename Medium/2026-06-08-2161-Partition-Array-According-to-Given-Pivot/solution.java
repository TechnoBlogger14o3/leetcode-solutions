class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int leftIndex = 0, rightIndex = n - 1;

        for (int num : nums) {
            if (num < pivot) {
                result[leftIndex++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                result[leftIndex++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                result[rightIndex--] = num;
            }
        }

        return result;
    }
}