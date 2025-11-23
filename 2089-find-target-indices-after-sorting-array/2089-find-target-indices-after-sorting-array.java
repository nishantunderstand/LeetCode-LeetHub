// Leetcode : 2089
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {        
        //return bySorting(nums,target);
        
        Arrays.sort(nums);  //<--
        List<Integer> res = new ArrayList<>();
        recursiveApproach(nums,target,0,res);
        return res;
    }

    // Sunday, November 23, 2025 1:45:18 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private void recursiveApproach(int[] nums, int target, int index, List<Integer> res){
        if(index == nums.length) return;
        if(nums[index]==target) res.add(index);
        recursiveApproach(nums,target,index+1,res);

    }

    // Friday, May 16, 2025 4:58:23 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(n)
    public List<Integer> bySorting(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;        
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                res.add(i);
            }
        }
        return res;
    }
}