/**
 * Time Complexity: O(n log n) - TreeMap operations
 * Space Complexity: O(n) - TreeMap
 */
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        while (!cardCount.isEmpty()) {
            int firstCard = cardCount.firstKey();
            
            for (int i = 0; i < groupSize; i++) {
                int card = firstCard + i;
                if (!cardCount.containsKey(card)) {
                    return false;
                }
                
                cardCount.put(card, cardCount.get(card) - 1);
                if (cardCount.get(card) == 0) {
                    cardCount.remove(card);
                }
            }
        }
        
        return true;
    }
}

// Alternative approach using HashMap + Sorting
class SolutionHashMap {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        List<Integer> sortedCards = new ArrayList<>(cardCount.keySet());
        Collections.sort(sortedCards);
        
        for (int card : sortedCards) {
            int count = cardCount.get(card);
            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = card + i;
                    if (!cardCount.containsKey(currentCard) || cardCount.get(currentCard) < count) {
                        return false;
                    }
                    cardCount.put(currentCard, cardCount.get(currentCard) - count);
                }
            }
        }
        
        return true;
    }
}

// Alternative approach using Priority Queue
class SolutionPriorityQueue {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(cardCount.keySet());
        
        while (!minHeap.isEmpty()) {
            int firstCard = minHeap.peek();
            
            for (int i = 0; i < groupSize; i++) {
                int card = firstCard + i;
                if (!cardCount.containsKey(card) || cardCount.get(card) == 0) {
                    return false;
                }
                
                cardCount.put(card, cardCount.get(card) - 1);
                if (cardCount.get(card) == 0) {
                    cardCount.remove(card);
                    minHeap.remove(card);
                }
            }
        }
        
        return true;
    }
}

// Alternative approach using Array
class SolutionArray {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        List<Integer> sortedCards = new ArrayList<>(cardCount.keySet());
        Collections.sort(sortedCards);
        
        for (int card : sortedCards) {
            int count = cardCount.get(card);
            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = card + i;
                    if (!cardCount.containsKey(currentCard) || cardCount.get(currentCard) < count) {
                        return false;
                    }
                    cardCount.put(currentCard, cardCount.get(currentCard) - count);
                }
            }
        }
        
        return true;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        while (!cardCount.isEmpty()) {
            int firstCard = cardCount.firstKey();
            
            for (int i = 0; i < groupSize; i++) {
                int card = firstCard + i;
                if (!cardCount.containsKey(card)) {
                    return false;
                }
                
                cardCount.put(card, cardCount.get(card) - 1);
                if (cardCount.get(card) == 0) {
                    cardCount.remove(card);
                }
            }
        }
        
        return true;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        while (!cardCount.isEmpty()) {
            int firstCard = cardCount.firstKey();
            
            for (int i = 0; i < groupSize; i++) {
                int card = firstCard + i;
                if (!cardCount.containsKey(card)) {
                    return false;
                }
                
                cardCount.put(card, cardCount.get(card) - 1);
                if (cardCount.get(card) == 0) {
                    cardCount.remove(card);
                }
            }
        }
        
        return true;
    }
}

// More concise version
class SolutionConcise {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        while (!cardCount.isEmpty()) {
            int firstCard = cardCount.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int card = firstCard + i;
                if (!cardCount.containsKey(card)) return false;
                
                cardCount.put(card, cardCount.get(card) - 1);
                if (cardCount.get(card) == 0) cardCount.remove(card);
            }
        }
        
        return true;
    }
}
