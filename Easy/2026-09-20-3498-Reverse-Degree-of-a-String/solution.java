class Solution {
    public int reverseDegree(String s) {
        int reverseDegree = 0;
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int positionInReversedAlphabet = 26 - (c - 'a');
            int positionInString = i + 1;
            reverseDegree += positionInReversedAlphabet * positionInString;
        }
        
        return reverseDegree;
    }
}