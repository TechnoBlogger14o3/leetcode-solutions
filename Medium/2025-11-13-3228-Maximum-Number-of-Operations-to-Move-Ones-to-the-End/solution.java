class Solution {
    public int maximumOperations(String s) {
        int countOnes = 0;
        int operations = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '1') {
                countOnes++;
            } else if (countOnes > 0) {
                operations += countOnes;
            }
        }
        
        return operations;
    }
}