class Solution {
    public int maximizeMinPower(int[] stations, int r, int k) {
        int n = stations.length;
        int left = 0, right = (int) 1e9;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canAchieve(stations, r, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canAchieve(int[] stations, int r, int k, int target) {
        int n = stations.length;
        long[] power = new long[n + 1];
        long totalAdded = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                power[i] += power[i - 1];
            }
            long currentPower = stations[i] + power[i];
            if (currentPower < target) {
                long needed = target - currentPower;
                totalAdded += needed;
                if (totalAdded > k) {
                    return false;
                }
                if (i + 2 * r + 1 < n) {
                    power[i + 2 * r + 1] -= needed;
                }
                power[i] += needed;
            }
        }
        return totalAdded <= k;
    }
}