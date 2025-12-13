class Solution:
    def couponCodes(self, code: List[str], businessLine: List[str], isActive: List[bool]) -> List[str]:
        valid_business_lines = {"electronics": 0, "grocery": 1, "pharmacy": 2, "restaurant": 3}
        
        valid_coupons = []
        
        for c, bl, active in zip(code, businessLine, isActive):
            if (c and c.replace('_', '').isalnum() and 
                bl in valid_business_lines and 
                active):
                valid_coupons.append((bl, c))
        
        valid_coupons.sort(key=lambda x: (valid_business_lines[x[0]], x[1]))
        
        return [c for _, c in valid_coupons]