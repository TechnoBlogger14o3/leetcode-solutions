class Solution {
    public int totalWaviness(int num1, int num2) {
        int totalWaviness = 0;
        
        for (int i = num1; i <= num2; i++) {
            totalWaviness += calculateWaviness(i);
        }
        
        return totalWaviness;
    }
    
    private int calculateWaviness(int num) {
        String str = String.valueOf(num);
        int waviness = 0;
        
        for (int i = 1; i < str.length() - 1; i++) {
            char prev = str.charAt(i - 1);
            char curr = str.charAt(i);
            char next = str.charAt(i + 1);
            
            if (curr > prev && curr > next) {
                waviness++; // peak
            } else if (curr < prev && curr < next) {
                waviness++; // valley
            }
        }
        
        return waviness;
    }
}