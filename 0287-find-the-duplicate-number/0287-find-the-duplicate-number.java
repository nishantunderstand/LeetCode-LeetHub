// Leetcode : 287
/**
Here I need to return the Element , Not the Index
1. Sorting , then compare
    Then I need to Duplicate Case 
2. HashMap , value count >1 , Much Better
    You cannot use 2 Pass - NO
    You need to solve in 1 Pass

Floyd's Tortoise and Hare algorithm
*/

class Solution {
    // Wednesday, May 14, 2025 9:15:41 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(Integer num : nums){
            if(hm.containsKey(num)){
                return num;
            }
            hm.put(num,1); // Why are we not checking getOrDefault ?
        }
        return -1;         
    }
}