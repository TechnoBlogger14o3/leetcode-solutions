class Solution {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int count = 1, index = 0;

        // Count the length of consecutive groups of 0's and 1's
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                groups[index++] = count;
                count = 1;
            }
        }
        groups[index] = count; // Add the last group

        int result = 0;
        // Count valid substrings
        for (int i = 1; i <= index; i++) {
            result += Math.min(groups[i - 1], groups[i]);
        }

        return result;
    }
}