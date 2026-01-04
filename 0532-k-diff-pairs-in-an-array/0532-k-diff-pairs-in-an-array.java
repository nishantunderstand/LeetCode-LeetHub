// Leetcode : 532
class Solution {
    public int findPairs(int[] nums, int k) {
        //return hashMapApproach(nums,k); // FAILED
        return twoPointer(nums,k);        
    }
    // UnSorted + Duplicate 
    private int twoPointer(int[] nums, int k){
        if(nums==null || nums.length<2) return 0;
        Arrays.sort(nums);
        int start = 0;
        int end = 1;
        int pcnt = 0;
        while(start<nums.length && end<nums.length){
            if(start==end){
                end++;
                continue;
            }
            int diff = nums[end] - nums[start];
            if(diff==k){
                pcnt++;
                int leftVal = nums[start];
                int rightVal = nums[end];
                while(start<nums.length && nums[start]==leftVal) start++;
                while(end<nums.length && nums[end]==rightVal) end++;
            }else if(diff<k){
                end++;
            }else if(diff>k){
                start++;
            }
        }
        return pcnt;
    }

    public int hashMapApproach(int[] nums, int k) {
        int cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();      
        for(int i=0;i<nums.length;i++){
            cnt = cnt + hm.getOrDefault(nums[i]-k,0) + hm.getOrDefault(nums[i]+k,0);
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        return cnt;
    }
}