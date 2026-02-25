import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if (countA == countB) {
                return Integer.compare(a, b);
            }
            return Integer.compare(countA, countB);
        });
        return arr;
    }
}