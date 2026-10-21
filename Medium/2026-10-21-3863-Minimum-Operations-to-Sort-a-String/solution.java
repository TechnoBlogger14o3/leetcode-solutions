class Solution {
    public int minimumOperations(String s) {
        int n = s.length();
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        
        int operations = 0;
        int i = 0, j = 0;
        
        while (i < n) {
            if (s.charAt(i) != sorted[j]) {
                operations++;
                while (i < n && s.charAt(i) != sorted[j]) {
                    i++;
                }
            } else {
                i++;
                j++;
            }
        }
        
        return operations == 0 ? -1 : operations;
    }
}