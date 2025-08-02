import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int minVal = Integer.MAX_VALUE; 

        for(int i = 0; i < n; i++){
            map1.put(basket1[i], map1.getOrDefault(basket1[i], 0) + 1);
            map2.put(basket2[i], map2.getOrDefault(basket2[i], 0) + 1);
            minVal = Math.min(minVal, basket1[i]);
            minVal = Math.min(minVal, basket2[i]);
        }

        List<Integer> swapList1 = new ArrayList<>();
        for(int key: map1.keySet()){
            int c1 = map1.get(key);
            int c2 = map2.getOrDefault(key, 0);
            if((c1 + c2) % 2 == 1) return -1; 
            if(c1 > c2){
                int addCnt = (c1 - c2) / 2;
                while(addCnt-- > 0){
                    swapList1.add(key);
                }
            }
        }

        List<Integer> swapList2 = new ArrayList<>();
        for(int key: map2.keySet()){
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.get(key);
            if((c1 + c2) % 2 == 1) return -1;  
            if(c2 > c1){
                int addCnt = (c2 - c1) / 2;
                while(addCnt-- > 0){
                    swapList2.add(key);
                }
            }
        }

        Collections.sort(swapList1);
        Collections.sort(swapList2, (a, b) -> b - a);

        long res = 0;
        for(int i = 0; i < swapList1.size(); i++){
            res += Math.min(2 * minVal, 
                            Math.min(swapList1.get(i), swapList2.get(i))
                           );
        }

        return res;
    }
} 