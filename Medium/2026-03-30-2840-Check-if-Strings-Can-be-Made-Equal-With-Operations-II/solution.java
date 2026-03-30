class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int n = s1.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        for (int i = 0; i < n; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        
        StringBuilder s1Even = new StringBuilder();
        StringBuilder s1Odd = new StringBuilder();
        StringBuilder s2Even = new StringBuilder();
        StringBuilder s2Odd = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                s1Even.append(s1.charAt(i));
                s2Even.append(s2.charAt(i));
            } else {
                s1Odd.append(s1.charAt(i));
                s2Odd.append(s2.charAt(i));
            }
        }
        
        return s1Even.toString().equals(s2Even.toString()) && s1Odd.toString().equals(s2Odd.toString());
    }
}