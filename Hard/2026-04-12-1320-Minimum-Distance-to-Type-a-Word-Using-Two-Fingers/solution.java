class Solution {
    private final int[][] keyboard = new int[26][2];

    public int minimumDistance(String word) {
        initializeKeyboard();
        int n = word.length();
        Integer[][][] dp = new Integer[n + 1][27][27];
        return dfs(word, 0, 26, 26, dp);
    }

    private int dfs(String word, int index, int finger1, int finger2, Integer[][][] dp) {
        if (index == word.length()) return 0;
        if (dp[index][finger1][finger2] != null) return dp[index][finger1][finger2];

        int letterIndex = word.charAt(index) - 'A';
        int distance1 = (finger1 == 26) ? 0 : getDistance(finger1, letterIndex);
        int distance2 = (finger2 == 26) ? 0 : getDistance(finger2, letterIndex);

        int moveFinger1 = distance1 + dfs(word, index + 1, letterIndex, finger2, dp);
        int moveFinger2 = distance2 + dfs(word, index + 1, finger1, letterIndex, dp);

        dp[index][finger1][finger2] = Math.min(moveFinger1, moveFinger2);
        return dp[index][finger1][finger2];
    }

    private int getDistance(int finger, int letter) {
        return Math.abs(keyboard[finger][0] - keyboard[letter][0]) + Math.abs(keyboard[finger][1] - keyboard[letter][1]);
    }

    private void initializeKeyboard() {
        for (int i = 0; i < 26; i++) {
            keyboard[i][0] = i / 6; // x-coordinate
            keyboard[i][1] = i % 6; // y-coordinate
        }
    }
}