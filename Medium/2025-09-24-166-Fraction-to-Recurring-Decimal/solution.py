class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0:
            return "0"
        
        res = []
        if (numerator < 0) ^ (denominator < 0):
            res.append("-")
        
        numerator, denominator = abs(numerator), abs(denominator)
        integer_part = numerator // denominator
        res.append(str(integer_part))
        
        remainder = numerator % denominator
        if remainder == 0:
            return ''.join(res)
        
        res.append(".")
        remainder_map = {}
        
        while remainder != 0:
            if remainder in remainder_map:
                index = remainder_map[remainder]
                res.insert(index, "(")
                res.append(")")
                break
            
            remainder_map[remainder] = len(res)
            remainder *= 10
            res.append(str(remainder // denominator))
            remainder %= denominator
        
        return ''.join(res)