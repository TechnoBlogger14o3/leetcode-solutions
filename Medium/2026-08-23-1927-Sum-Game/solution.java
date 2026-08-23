class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;
        int sum1 = 0, sum2 = 0, question1 = 0, question2 = 0;

        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                question1++;
            } else {
                sum1 += c - '0';
            }
        }

        for (int i = half; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                question2++;
            } else {
                sum2 += c - '0';
            }
        }

        int totalQuestions = question1 + question2;
        int diff = sum1 - sum2;

        if (diff == 0) {
            return totalQuestions % 2 == 1; // If the difference is 0, Alice can only win if there's an odd number of '?'
        }

        int maxDiff = Math.abs(diff) + (question1 > question2 ? question1 : question2) * 9;
        return maxDiff > 0 && (maxDiff % 2 == 1 || totalQuestions % 2 == 1);
    }
}