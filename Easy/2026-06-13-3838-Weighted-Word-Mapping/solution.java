class Solution {
    public String weightedWordMapping(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            int weightSum = 0;
            for (char c : word.toCharArray()) {
                weightSum += weights[c - 'a'];
            }
            int mappedIndex = weightSum % 26;
            char mappedChar = (char) ('z' - mappedIndex);
            result.append(mappedChar);
        }
        
        return result.toString();
    }
}