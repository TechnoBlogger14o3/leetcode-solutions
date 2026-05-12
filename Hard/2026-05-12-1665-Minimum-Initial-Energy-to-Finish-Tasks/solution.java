import java.util.Arrays;

class Solution {
    public int minimumEnergy(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> Integer.compare(b[1], a[1]));
        
        int totalEnergy = 0;
        int currentEnergy = 0;
        
        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];
            
            if (currentEnergy < minimum) {
                totalEnergy += minimum - currentEnergy;
                currentEnergy = minimum;
            }
            currentEnergy -= actual;
        }
        
        return totalEnergy;
    }
}