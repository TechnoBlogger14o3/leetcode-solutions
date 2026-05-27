class Solution {
    public int countSpecialCharacters(String word) {
        int count = 0;
        boolean[] seenLower = new boolean[26];
        boolean[] seenUpper = new boolean[26];
        
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                seenLower[c - 'a'] = true;
            } else {
                seenUpper[c - 'A'] = true;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (seenLower[i] && seenUpper[i] && isLowerBeforeUpper(word, (char) (i + 'a'), (char) (i + 'A'))) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isLowerBeforeUpper(String word, char lower, char upper) {
        boolean lowerFound = false;
        for (char c : word.toCharArray()) {
            if (c == lower) {
                lowerFound = true;
            } else if (c == upper) {
                return lowerFound;
            }
        }
        return false;
    }
}