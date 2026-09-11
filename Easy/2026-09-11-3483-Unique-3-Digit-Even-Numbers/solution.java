import java.util.HashSet;

class Solution {
    public int countDistinctEvenNumbers(int[] digits) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            if (digits[i] % 2 == 0) { // Check if the digit is even
                boolean[] used = new boolean[n];
                used[i] = true;
                for (int j = 0; j < n; j++) {
                    if (!used[j] && digits[j] != 0) { // Avoid leading zero
                        used[j] = true;
                        for (int k = 0; k < n; k++) {
                            if (!used[k]) {
                                uniqueNumbers.add(digits[j] * 100 + digits[i] * 10 + digits[k]);
                            }
                        }
                        used[j] = false;
                    }
                }
                used[i] = false;
            }
        }
        
        return uniqueNumbers.size();
    }
}