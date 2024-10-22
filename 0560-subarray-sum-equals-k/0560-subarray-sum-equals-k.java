/**
Sunday, June 9, 2024 2:17:34 PM
Time Complexity: O(n^2)
Space Complexity: O(1)
Please Update Here, TimeComplexity and SpaceComplexity of the Code. Explain in Detail.
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {                
                    sum += nums[j];                    
                if (sum == k){
                    count++;
                    }
                }
            }
        return count;
    }	
}