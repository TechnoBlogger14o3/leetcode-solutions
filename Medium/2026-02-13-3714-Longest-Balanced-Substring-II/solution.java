class Solution {
    public int longestBalancedSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int targetCount = 1; targetCount <= n; targetCount++) {
            int[] count = new int[3]; // count for 'a', 'b', 'c'
            int distinctChars = 0;

            for (int i = 0; i < n; i++) {
                int index = s.charAt(i) - 'a';
                count[index]++;
                if (count[index] == targetCount) {
                    distinctChars++;
                }
                if (distinctChars == 3) {
                    maxLength = Math.max(maxLength, i + 1);
                }
                if (count[index] > targetCount) {
                    while (count[index] > targetCount) {
                        count[s.charAt(i - (i - (i - 1) + 1)) - 'a']--;
                        if (count[s.charAt(i - (i - 1) + 1) - 'a'] == targetCount - 1) {
                            distinctChars--;
                        }
                        i--;
                    }
                }
            }
        }

        return maxLength;
    }
}