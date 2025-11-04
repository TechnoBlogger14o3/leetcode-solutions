from collections import Counter
from typing import List

def xSum(nums: List[int], k: int, x: int) -> List[int]:
    n = len(nums)
    answer = []
    
    for i in range(n - k + 1):
        subarray = nums[i:i + k]
        count = Counter(subarray)
        most_common = count.most_common(x)
        
        # If there are less than x distinct elements, sum all
        if len(most_common) < x:
            answer.append(sum(subarray))
        else:
            # Keep only the top x most frequent elements
            top_elements = sorted(most_common, key=lambda item: (-item[1], -item[0]))
            top_values = [val for val, freq in top_elements]
            result_sum = sum(val for val in subarray if val in top_values)
            answer.append(result_sum)
    
    return answer