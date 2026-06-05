public class Solution {
    public long totalWaviness(long num1, long num2) {
        long totalWaviness = 0;
        for (long i = num1; i <= num2; i++) {
            totalWaviness += calculateWaviness(i);
        }
        return totalWaviness;
    }

    private int calculateWaviness(long number) {
        String numStr = Long.toString(number);
        int waviness = 0;
        int length = numStr.length();
        
        if (length < 3) {
            return 0;
        }
        
        for (int j = 1; j < length - 1; j++) {
            char left = numStr.charAt(j - 1);
            char mid = numStr.charAt(j);
            char right = numStr.charAt(j + 1);
            
            if (mid > left && mid > right) {
                waviness++; // peak
            } else if (mid < left && mid < right) {
                waviness++; // valley
            }
        }
        
        return waviness;
    }
}