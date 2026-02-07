class Solution {
    public int minimumDeletions(String s) {
        int countA = 0, countB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                countA++;
            } else {
                countB++;
            }
        }
        
        int minDeletions = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                countA--;
            } else {
                countB--;
                minDeletions = Math.min(minDeletions + 1, countA);
            }
        }
        
        return minDeletions;
    }
}