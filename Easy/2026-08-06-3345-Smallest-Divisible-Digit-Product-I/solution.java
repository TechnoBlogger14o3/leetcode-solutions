class Solution {
    public int smallestEvenDigitProduct(int n, int t) {
        for (int i = n; ; i++) {
            if (productOfDigits(i) % t == 0) {
                return i;
            }
        }
    }

    private int productOfDigits(int num) {
        int product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }
}