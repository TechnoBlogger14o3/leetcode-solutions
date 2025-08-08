import java.util.*;

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        List<Integer> sect_mx = new ArrayList<>();
        int m = baskets.length;
        int a = (int) Math.sqrt(m); // size of one array

        int cnt = 0, mx = 0;
        for (int i = 0; i < m; i++) {
            if (cnt == a) {
                // creating sector of size a
                sect_mx.add(mx);
                mx = baskets[i];
                cnt = 1;
            } else {
                cnt++;
                mx = Math.max(mx, baskets[i]);
            }
        }

        // last sector
        sect_mx.add(mx);

        int remain = 0;

        // start allocating
        for (int i = 0; i < fruits.length; i++) {
            int k = 0, set = 1;

            for (int j = 0; j < m; j += a) {
                if (sect_mx.get(k) < fruits[i]) {
                    // skip this segment
                    k++;
                    continue;
                }

                // find place to allocate
                for (int r = j; r < Math.min(j + a, m); r++) {
                    if (baskets[r] >= fruits[i]) {
                        set = 0;
                        baskets[r] = 0;
                        break;
                    }
                }

                // if fruit is allocated in a sector
                if (set == 0) {
                    sect_mx.set(k, 0); // find new mx
                    // update new sector mx
                    for (int r = j; r < Math.min(j + a, m); r++) {
                        sect_mx.set(k, Math.max(baskets[r], sect_mx.get(k)));
                    }
                    break;
                }

                k++;
            }

            remain += set;
        }

        return remain;
    }
} 