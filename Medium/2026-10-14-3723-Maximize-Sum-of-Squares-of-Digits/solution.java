class Solution {
    public String maximumSumOfDigits(int num, int sum) {
        if (sum > 9 * num || sum < 1) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            result.append(digit);
            sum -= digit;
        }
        
        return result.toString();
    }
}