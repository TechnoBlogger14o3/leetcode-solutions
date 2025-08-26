class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        if (dimensions == null || dimensions.length == 0) return 0;
        
        double maxDiagonal = 0;
        int maxArea = 0;
        
        for (int[] rect : dimensions) {
            int length = rect[0];
            int width = rect[1];
            
            // Calculate diagonal length using Pythagorean theorem
            double diagonal = Math.sqrt(length * length + width * width);
            
            // If this diagonal is longer, update both diagonal and area
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = length * width;
            }
            // If diagonal is equal, keep the rectangle with larger area
            else if (Math.abs(diagonal - maxDiagonal) < 1e-9) {
                maxArea = Math.max(maxArea, length * width);
            }
        }
        
        return maxArea;
    }
}
