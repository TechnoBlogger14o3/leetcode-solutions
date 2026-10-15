class Solution {
    public int distinctElementSumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> distinctElements = new HashSet<>();
            for (int j = i; j < n; j++) {
                distinctElements.add(nums[j]);
                sum += distinctElements.size() * distinctElements.size();
            }
        }

        return sum;
    }
}