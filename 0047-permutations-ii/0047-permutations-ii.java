class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return anjApproach(nums);
        
    }

    // Tuesday, February 4, 2025 10:47:01 PM
    // Time Complexity:O(n!) | Space Complexity:O(n)
    public List<List<Integer>> anjApproach(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int n = nums.length;
        boolean[] vis = new boolean[n];
        Arrays.sort(nums); // <-- This is Additional Line
        permuteHelper(res,curr,vis,nums);
        return res;
    }
    public void permuteHelper(List<List<Integer>> res,List<Integer> curr,boolean[] vis,int[] nums) {
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(vis[i]) continue;
            if(i!=0 && nums[i]==nums[i-1] && !vis[i-1]) continue; // <-- This is Additional Line

            curr.add(nums[i]);
            vis[i]=true;
            permuteHelper(res,curr,vis,nums);
            curr.remove(curr.size()-1);
            vis[i]=false;
        }
    }   
}