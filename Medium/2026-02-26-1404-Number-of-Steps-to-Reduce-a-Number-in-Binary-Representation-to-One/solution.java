class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int n = s.length();
        
        for (int i = n - 1; i > 0; i--) {
            if (s.charAt(i) == '1') {
                steps += 2; // Add 1 and then divide by 2
            } else {
                steps += 1; // Just divide by 2
            }
        }
        
        return steps;
    }
}