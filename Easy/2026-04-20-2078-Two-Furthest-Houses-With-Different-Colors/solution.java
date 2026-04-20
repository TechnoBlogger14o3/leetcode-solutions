class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int firstColor = colors[0];
        int lastColor = colors[n - 1];
        
        int maxDistance = 0;
        
        // Check distance from the first house
        if (firstColor != lastColor) {
            maxDistance = n - 1; // Distance between first and last house
        } else {
            // Find the furthest house with a different color from the first house
            for (int i = n - 1; i >= 0; i--) {
                if (colors[i] != firstColor) {
                    maxDistance = Math.max(maxDistance, i);
                    break;
                }
            }
            // Find the furthest house with a different color from the last house
            for (int i = 0; i < n; i++) {
                if (colors[i] != lastColor) {
                    maxDistance = Math.max(maxDistance, n - 1 - i);
                    break;
                }
            }
        }
        
        return maxDistance;
    }
}