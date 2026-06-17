class Solution {
    public String processString(String s, long k) {
        StringBuilder result = new StringBuilder();
        long length = 0;

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(c);
                length++;
            } else if (c == '*') {
                if (length > 0) {
                    result.deleteCharAt(result.length() - 1);
                    length--;
                }
            } else if (c == '#') {
                String temp = result.toString();
                result.append(temp);
                length *= 2;
            } else if (c == '%') {
                result.reverse();
            }
        }

        if (k >= length) {
            return ".";
        } else {
            return String.valueOf(result.charAt((int) k));
        }
    }
}