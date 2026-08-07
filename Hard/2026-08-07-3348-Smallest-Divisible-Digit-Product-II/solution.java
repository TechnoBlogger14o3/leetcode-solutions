import java.math.BigInteger;

class Solution {
    public String smallestDivisibleDigitProduct(String num, int t) {
        BigInteger target = new BigInteger(num);
        BigInteger tBig = BigInteger.valueOf(t);
        
        while (true) {
            if (isZeroFree(num) && isProductDivisible(num, tBig)) {
                return num;
            }
            num = increment(num);
            if (num.length() > 200000) {
                return "-1";
            }
        }
    }

    private boolean isZeroFree(String num) {
        for (char c : num.toCharArray()) {
            if (c == '0') {
                return false;
            }
        }
        return true;
    }

    private boolean isProductDivisible(String num, BigInteger t) {
        BigInteger product = BigInteger.ONE;
        for (char c : num.toCharArray()) {
            product = product.multiply(BigInteger.valueOf(c - '0'));
        }
        return product.mod(t).equals(BigInteger.ZERO);
    }

    private String increment(String num) {
        BigInteger bigNum = new BigInteger(num);
        bigNum = bigNum.add(BigInteger.ONE);
        return bigNum.toString();
    }
}