// Leetcode : 303
class NumArray {
    private int pf[];
    
    // Friday, May 16, 2025 11:21:42 AM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public NumArray(int[] nums) {
        pf = new int[nums.length];
        int n = nums.length;
        
        pf[0]=nums[0];
        for(int i=1;i<n;i++){
            pf[i]=pf[i-1]+nums[i];
        }
    }
    
    // Friday, May 16, 2025 11:21:42 AM
    // Time Complexity:O(1) | Space Complexity:O(1)
    public int sumRange(int left, int right) {  
        int sum=0;
        if(left==0){
            sum=pf[right];
        }else{
            sum = pf[right]-pf[left-1];
        }
        
        return sum;      
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */