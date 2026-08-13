class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int k = queryCharacters.length();
        int[] lengths = new int[k];
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < k; i++) {
            chars[queryIndices[i]] = queryCharacters.charAt(i);
            lengths[i] = getMaxLength(chars);
        }
        
        return lengths;
    }
    
    private int getMaxLength(char[] chars) {
        int maxLength = 1;
        int currentLength = 1;
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        
        return Math.max(maxLength, currentLength);
    }
}