/**
 * Time Complexity: O(max(m, n)) - Where m, n are string lengths
 * Space Complexity: O(max(m, n)) - Result string
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        return result.reverse().toString();
    }
}

// Alternative approach using built-in functions
class SolutionBuiltIn {
    public String addBinary(String a, String b) {
        int numA = Integer.parseInt(a, 2);
        int numB = Integer.parseInt(b, 2);
        int sum = numA + numB;
        return Integer.toBinaryString(sum);
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        return result.reverse().toString();
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        return result.reverse().toString();
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        return result.reverse().toString();
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public String addBinary(String a, String b) {
        return addBinaryHelper(a, b, a.length() - 1, b.length() - 1, 0, new StringBuilder()).reverse().toString();
    }
    
    private StringBuilder addBinaryHelper(String a, String b, int i, int j, int carry, StringBuilder result) {
        if (i < 0 && j < 0 && carry == 0) {
            return result;
        }
        
        int sum = carry;
        
        if (i >= 0) {
            sum += a.charAt(i) - '0';
        }
        
        if (j >= 0) {
            sum += b.charAt(j) - '0';
        }
        
        result.append(sum % 2);
        carry = sum / 2;
        
        return addBinaryHelper(a, b, i - 1, j - 1, carry, result);
    }
}

// Alternative approach using string manipulation
class SolutionStringManipulation {
    public String addBinary(String a, String b) {
        // Pad shorter string with leading zeros
        int maxLen = Math.max(a.length(), b.length());
        a = String.format("%" + maxLen + "s", a).replace(' ', '0');
        b = String.format("%" + maxLen + "s", b).replace(' ', '0');
        
        StringBuilder result = new StringBuilder();
        int carry = 0;
        
        for (int i = maxLen - 1; i >= 0; i--) {
            int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry > 0) {
            result.append(carry);
        }
        
        return result.reverse().toString();
    }
}

// Alternative approach using bit manipulation
class SolutionBitManipulation {
    public String addBinary(String a, String b) {
        int numA = 0, numB = 0;
        
        for (char c : a.toCharArray()) {
            numA = (numA << 1) | (c - '0');
        }
        
        for (char c : b.toCharArray()) {
            numB = (numB << 1) | (c - '0');
        }
        
        int sum = numA + numB;
        
        if (sum == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        while (sum > 0) {
            result.append(sum & 1);
            sum >>= 1;
        }
        
        return result.reverse().toString();
    }
}

// More concise version
class SolutionConcise {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        return result.reverse().toString();
    }
}
