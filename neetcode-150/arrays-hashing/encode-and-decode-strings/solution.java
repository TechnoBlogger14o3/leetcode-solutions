import java.util.*;

/**
 * Time Complexity: O(n) - Where n is total characters
 * Space Complexity: O(1) - Excluding input/output
 */
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        
        for (String str : strs) {
            encoded.append(str.length()).append('#').append(str);
        }
        
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            // Find the delimiter '#'
            int delimiterIndex = s.indexOf('#', i);
            
            // Extract length
            int length = Integer.parseInt(s.substring(i, delimiterIndex));
            
            // Extract string
            String str = s.substring(delimiterIndex + 1, delimiterIndex + 1 + length);
            decoded.add(str);
            
            // Move to next string
            i = delimiterIndex + 1 + length;
        }
        
        return decoded;
    }
}

// Alternative approach using more explicit parsing
class CodecAlternative {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        
        return sb.toString();
    }
    
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            
            int length = Integer.parseInt(s.substring(i, j));
            String str = s.substring(j + 1, j + 1 + length);
            result.add(str);
            
            i = j + 1 + length;
        }
        
        return result;
    }
}

// Using streams for more functional approach
class CodecStreams {
    public String encode(List<String> strs) {
        return strs.stream()
                .map(str -> str.length() + "#" + str)
                .reduce("", String::concat);
    }
    
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int delimiterIndex = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, delimiterIndex));
            String str = s.substring(delimiterIndex + 1, delimiterIndex + 1 + length);
            result.add(str);
            i = delimiterIndex + 1 + length;
        }
        
        return result;
    }
}
