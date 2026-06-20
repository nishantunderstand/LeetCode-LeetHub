// Two Way Partition
// Sunday, June 14, 2026 1:08:48 AM
// TC : O(2^nnlognk) | SC : O(2^n1logkh)
// LeetCode : 922
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;

        while(even<nums.length && odd <nums.length){
            if(nums[even]%2==0){
                even+=2;
            }
            else if(nums[odd]%2==1){
                odd+=2;
            }             
            else{
                swap(nums,odd,even);
                odd +=2;
                even +=2;
            }            
        }
        return nums;
    }

    private void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

// How to Update it ???