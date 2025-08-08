from typing import List
import math

class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        sect_mx = []
        m = len(baskets)
        a = int(math.sqrt(m))  # size of one array

        cnt = 0
        mx = 0
        for i in range(m):
            if cnt == a:
                # creating sector of size a
                sect_mx.append(mx)
                mx = baskets[i]
                cnt = 1
            else:
                cnt += 1
                mx = max(mx, baskets[i])

        # last sector
        sect_mx.append(mx)

        remain = 0

        # start allocating
        for i in range(len(fruits)):
            k = 0
            set_val = 1

            for j in range(0, m, a):
                if sect_mx[k] < fruits[i]:
                    # skip this segment
                    k += 1
                    continue

                # find place to allocate
                for r in range(j, min(j + a, m)):
                    if baskets[r] >= fruits[i]:
                        set_val = 0
                        baskets[r] = 0
                        break

                # if fruit is allocated in a sector
                if set_val == 0:
                    sect_mx[k] = 0  # find new mx
                    # update new sector mx
                    for r in range(j, min(j + a, m)):
                        sect_mx[k] = max(baskets[r], sect_mx[k])
                    break

                k += 1

            remain += set_val

        return remain 