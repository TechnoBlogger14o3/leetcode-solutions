import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] count = new int[100001];
        for (int cost : costs) {
            count[cost]++;
        }
        
        int totalBars = 0;
        for (int price = 1; price < count.length; price++) {
            while (count[price] > 0 && coins >= price) {
                coins -= price;
                totalBars++;
                count[price]--;
            }
        }
        
        return totalBars;
    }
}