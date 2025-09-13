class Solution {
    public int maxVowelsAndConsonants(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            if ("aeiou".indexOf(c) != -1) {
                maxVowelFreq = Math.max(maxVowelFreq, freq[c - 'a']);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, freq[c - 'a']);
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }
}