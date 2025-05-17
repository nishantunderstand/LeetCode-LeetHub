// Leetcode : 204
class Solution {
    public int countPrimes(int n) {
        // return bruteForceCountFactor(n);
        // return bruteForcePrimeCheck(n);
        return sieveApproach(n);
        // return sieveApproachInteger(n);
    }

    public int sieveApproachInteger(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        isPrime[0] = 0;
        isPrime[1] = 0;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i] == 1) {
                for (int j = i * i; j < n; j = j + i) { 
                    isPrime[j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (isPrime[i] == 1) {
                count++;
            }
        }
        return count;
    }

    // Friday, January 3, 2025 2:19:51 PM
    // Time Complexity:O(nloglogn) | Space Complexity:O(n)
    public int sieveApproach(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == true) {
                cnt++;
            }
        }
        return cnt;
    }

    // Time Complexity: O(n * √n) | Space Complexity: O(1)
    public int bruteForcePrimeCheck(int n) {
        if (n <= 2)
            return 0;
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    // Time Complexity: O(√n) | Space Complexity: O(1)
    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Time Complexity: O(n * √n) | Space Complexity: O(1)
    public int bruteForceCountFactor(int n) {
        if (n <= 2)
            return 0;
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (countFactor(i) == 2) {
                cnt++;
            }
        }
        return cnt;
    }

    // Time Complexity: O(√n) | Space Complexity: O(1)
    public int countFactor(int n) {
        int cnt = 0;
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    cnt += 1;
                } else {
                    cnt += 2;
                }
            }
        }
        return cnt;
    }
}
