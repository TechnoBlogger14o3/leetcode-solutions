import java.util.Arrays;

class Solution {
    public int minBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }
        
        Arrays.sort(capacity);
        int boxesUsed = 0;
        for (int i = capacity.length - 1; i >= 0 && totalApples > 0; i--) {
            totalApples -= capacity[i];
            boxesUsed++;
        }
        
        return boxesUsed;
    }
}