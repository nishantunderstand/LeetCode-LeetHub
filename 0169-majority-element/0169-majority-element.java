// Friday, June 5, 2026 11:37:40 PM
// TC : O(n ) | SC : O(1 )
// LeetCode : 169

class Solution {
    public int majorityElement(int[] nums) {
        int element = mooreVoting(nums);
        return element;
    }

    private int mooreVoting(int[] nums){
        int element = 0;
        int count = 0;

        for(int num : nums){
            if(count == 0){
                element = num;
            }

            if(num==element){
                count++;
            }else{
                count--;
            }
        }
        return element;
    }
}