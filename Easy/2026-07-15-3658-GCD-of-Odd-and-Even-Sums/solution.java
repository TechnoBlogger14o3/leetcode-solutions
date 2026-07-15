class Solution {
    public int findGCD(int n) {
        int sumOdd = n * n; // Sum of first n odd numbers is n^2
        int sumEven = n * (n + 1); // Sum of first n even numbers is n * (n + 1)
        return gcd(sumOdd, sumEven);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}