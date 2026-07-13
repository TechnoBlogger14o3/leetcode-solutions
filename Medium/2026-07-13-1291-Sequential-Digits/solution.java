import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String seqDigits = "123456789";
        
        for (int len = 2; len <= 9; len++) {
            for (int start = 0; start <= 9 - len; start++) {
                int num = Integer.parseInt(seqDigits.substring(start, start + len));
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}