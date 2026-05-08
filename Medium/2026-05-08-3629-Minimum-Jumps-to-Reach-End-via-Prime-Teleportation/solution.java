import java.util.*;

public class Solution {
    public int minimumJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        // Sieve of Eratosthenes to find all primes up to 10^6
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Map to store indices of numbers divisible by primes
        Map<Integer, List<Integer>> primeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (isPrime[nums[i]]) {
                primeMap.putIfAbsent(nums[i], new ArrayList<>());
                primeMap.get(nums[i]).add(i);
            }
        }

        // BFS to find the minimum jumps
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (index == n - 1) return jumps;

                // Adjacent steps
                if (index + 1 < n && !visited[index + 1]) {
                    visited[index + 1] = true;
                    queue.offer(index + 1);
                }
                if (index - 1 >= 0 && !visited[index - 1]) {
                    visited[index - 1] = true;
                    queue.offer(index - 1);
                }

                // Prime teleportation
                if (isPrime[nums[index]]) {
                    for (int j : primeMap.get(nums[index])) {
                        if (j != index && !visited[j]) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                    primeMap.remove(nums[index]); // Clear to prevent future unnecessary checks
                }
            }
            jumps++;
        }
        return -1; // Should never reach here if input is valid
    }
}