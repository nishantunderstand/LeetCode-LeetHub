/**
26 July 23
Prefix Sum
I need to understand, How function is going to work.
*/
class NumArray {
    int pf[];

    public NumArray(int[] nums) {
        pf = new int[nums.length];
        int n = nums.length;
        pf[0]=nums[0];
        for(int i=1;i<n;i++){
            pf[i]=pf[i-1]+nums[i];
        }
    }
    
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