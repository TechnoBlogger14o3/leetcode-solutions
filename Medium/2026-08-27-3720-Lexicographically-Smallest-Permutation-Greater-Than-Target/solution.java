import java.util.Arrays;

public class Solution {
    public String nextPermutation(String s, String target) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sortedS = new String(chars);
        
        if (sortedS.compareTo(target) <= 0) {
            return "";
        }
        
        while (true) {
            if (sortedS.compareTo(target) > 0) {
                return sortedS;
            }
            sortedS = getNextPermutation(sortedS);
            if (sortedS == null) {
                break;
            }
        }
        return "";
    }

    private String getNextPermutation(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        
        int i = n - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            return null;
        }
        
        int j = n - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }
        
        swap(chars, i, j);
        reverse(chars, i + 1, n - 1);
        
        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start++, end--);
        }
    }
}