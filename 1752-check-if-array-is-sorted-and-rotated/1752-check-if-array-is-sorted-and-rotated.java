// LeetCode : 1752
class Solution {
    public boolean check(int[] nums) {              
        return checkRotatedSortedOnePass(nums);
    }
    // Sunday, January 18, 2026 6:33:37 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private boolean checkRotatedSortedOnePass(int[] nums) {
        int cnt=0;   
        int n = nums.length;  //<--
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){  //<--
                cnt++;
            }
            if(cnt>1){
                return false;
            }
        }        
        return true;
    }
}