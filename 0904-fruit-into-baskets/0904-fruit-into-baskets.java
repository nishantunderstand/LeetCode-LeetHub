// LeetCode : 904
class Solution {
    public int totalFruit(int[] fruits) {
        //return setApproach(fruits);
        return slidingWindowHashMap(fruits);
        // return slidingWindowHashSet(fruits); // FAIL
    }
    // max Length of subarray with atmost 2 types of Fruits
    private int slidingWindowHashMap(int[] fruits) {
        int maxFruits = 0;
        Map<Integer, Integer> fMap = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            int right = fruits[windowEnd];
            fMap.put(right, fMap.getOrDefault(right, 0) + 1);

            while (fMap.size() > 2) {
                int left = fruits[windowStart];
                fMap.put(left, fMap.get(left) - 1);
                if (fMap.get(left) == 0) {
                    fMap.remove(left);
                }
                windowStart++;
            }
            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
        }
        return maxFruits;
    }

    // Sunday, April 12, 2026 1:11:34 PM
    // TC : O(n*n) | SC : O(n)
    // TLE
    public int setApproach(int[] fruits) {
        int maxFruits = 0;
        for (int i = 0; i < fruits.length; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < fruits.length; j++) {
                seen.add(fruits[j]);

                if (seen.size() > 2) { //<--
                    break;
                }
                maxFruits = Math.max(maxFruits, j - i + 1); //<--
            }
        }
        return maxFruits;
    }
}