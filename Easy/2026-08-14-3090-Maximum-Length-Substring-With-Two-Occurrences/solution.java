class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0, right = 0, maxLength = 0;
        int[] count = new int[26];

        while (right < s.length()) {
            count[s.charAt(right) - 'a']++;
            
            while (count[s.charAt(right) - 'a'] > 2) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
}