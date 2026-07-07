class Solution {
    public int concatenatedProduct(int n) {
        StringBuilder nonZeroDigits = new StringBuilder();
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                nonZeroDigits.append(digit);
                sum += digit;
            }
            n /= 10;
        }

        if (nonZeroDigits.length() == 0) {
            return 0;
        }

        int x = Integer.parseInt(nonZeroDigits.reverse().toString());
        return x * sum;
    }
}