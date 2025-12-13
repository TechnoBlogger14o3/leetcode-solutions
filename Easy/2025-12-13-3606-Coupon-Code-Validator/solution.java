import java.util.*;

public class Solution {
    public List<String> couponCodes(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> validCoupons = new ArrayList<>();
        Set<String> validBusinessLines = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));

        for (int i = 0; i < code.length; i++) {
            if (isValidCoupon(code[i], businessLine[i], isActive[i], validBusinessLines)) {
                validCoupons.add(code[i]);
            }
        }

        validCoupons.sort(Comparator.comparingInt(this::getBusinessLineOrder).thenComparing(String::compareTo));
        return validCoupons;
    }

    private boolean isValidCoupon(String code, String businessLine, boolean isActive, Set<String> validBusinessLines) {
        return !code.isEmpty() && code.matches("[a-zA-Z0-9_]+") && validBusinessLines.contains(businessLine) && isActive;
    }

    private int getBusinessLineOrder(String code) {
        // This method is a placeholder to ensure sorting by business line
        // In a real implementation, we would map business lines to their respective order
        return 0; // Replace with actual mapping logic if needed
    }
}