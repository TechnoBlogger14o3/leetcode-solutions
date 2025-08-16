class Solution {
    public int maximum69Number(int num) {
        // Convert to string to easily manipulate digits
        String numStr = String.valueOf(num);
        char[] digits = numStr.toCharArray();
        
        // Find the first occurrence of '6' and change it to '9'
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // Only change the first occurrence
            }
        }
        
        // Convert back to integer
        return Integer.parseInt(new String(digits));
    }
}
