class Solution {
    public int minOperations(String s) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char expectedChar = (i % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != expectedChar) {
                count1++;
            }
            expectedChar = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != expectedChar) {
                count2++;
            }
        }
        return Math.min(count1, count2);
    }
}