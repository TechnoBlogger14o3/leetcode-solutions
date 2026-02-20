class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0, last = 0;
        List<String> specialStrings = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '1' ? 1 : -1;
            if (count == 0) {
                String inner = makeLargestSpecial(s.substring(last + 1, i));
                specialStrings.add("1" + inner + "0");
                last = i + 1;
            }
        }
        
        Collections.sort(specialStrings, Collections.reverseOrder());
        return String.join("", specialStrings);
    }
}