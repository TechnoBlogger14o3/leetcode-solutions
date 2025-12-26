class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;
        int minPenalty = Integer.MAX_VALUE;
        int bestTime = 0;

        for (char c : customers.toCharArray()) {
            if (c == 'N') {
                penalty++;
            }
        }

        for (int i = 0; i <= customers.length(); i++) {
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestTime = i;
            }
            if (i < customers.length() && customers.charAt(i) == 'Y') {
                penalty++;
            } else if (i < customers.length() && customers.charAt(i) == 'N') {
                penalty--;
            }
        }

        return bestTime;
    }
}