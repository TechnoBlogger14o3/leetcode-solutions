class Solution {
    public int maxEnergy(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int currentEnergy = 0;
            for (int j = i; j < n; j += k) {
                currentEnergy += energy[j];
            }
            maxEnergy = Math.max(maxEnergy, currentEnergy);
        }

        return maxEnergy;
    }
}