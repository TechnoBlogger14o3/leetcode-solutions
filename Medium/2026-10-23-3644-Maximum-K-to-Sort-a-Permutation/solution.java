class Solution {
    public int maximumK(int[] nums) {
        int n = nums.length;
        if (isSorted(nums)) return 0;

        int maxK = 0;
        for (int k = 0; k < n; k++) {
            if (canSortWithK(nums, k)) {
                maxK = k;
            }
        }
        return maxK;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }

    private boolean canSortWithK(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] || nums[i] == sorted[i]) continue;

            int cycleSize = 0;
            int x = i;
            while (!visited[x]) {
                visited[x] = true;
                x = findIndex(nums, sorted[x]);
                cycleSize++;
            }

            if (cycleSize > 1 && !canSwap(nums, k, i, sorted)) {
                return false;
            }
        }
        return true;
    }

    private int findIndex(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) return i;
        }
        return -1;
    }

    private boolean canSwap(int[] nums, int k, int i, int[] sorted) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == sorted[i] && (nums[i] & nums[j]) == k) {
                return true;
            }
        }
        return false;
    }
}