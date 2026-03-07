class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s += s; // Concatenate the string to handle rotations
        int count1 = 0, count2 = 0;

        // Count flips for both patterns: "010101..." and "101010..."
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0' + (i % 2)) count1++;
            if (s.charAt(i) != '1' - (i % 2)) count2++;
        }

        int minFlips = Math.min(count1, count2);
        for (int i = n; i < s.length(); i++) {
            // Slide the window
            if (s.charAt(i) != '0' + (i % 2)) count1++;
            if (s.charAt(i) != '1' - (i % 2)) count2++;
            if (s.charAt(i - n) != '0' + ((i - n) % 2)) count1--;
            if (s.charAt(i - n) != '1' - ((i - n) % 2)) count2--;
            minFlips = Math.min(minFlips, Math.min(count1, count2));
        }

        return minFlips;
    }
}