class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // Check if both strings are equal when sorted
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        
        return Arrays.equals(s1Chars, s2Chars);
    }
}