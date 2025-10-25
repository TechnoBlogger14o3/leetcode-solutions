class Solution {
    public long totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        long total = 0;

        // Calculate total for complete weeks
        total += (long) weeks * (7 * (weeks + 1) / 2);

        // Calculate total for remaining days
        total += (long) days * (weeks + 1) + (long) (days * (days - 1) / 2);

        return total;
    }
}