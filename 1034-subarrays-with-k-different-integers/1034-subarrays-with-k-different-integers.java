class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k)-atMostK(nums,k-1);
    }
    private int atMostK(int[] nums,int k){
        HashMap<Integer,Integer> count = new HashMap<>();
        int left = 0;
        int result = 0;
        int len = nums.length;
        for(int right=0;right<len;right++){
            
            int num = nums[right];
                        count.put(num, count.getOrDefault(num, 0) + 1); // Fixed typo here


            while(count.size()>k){
                int leftNum = nums[left];
                count.put(leftNum,count.get(leftNum)-1);
                if(count.get(leftNum)==0){
                    count.remove(leftNum);
                }
                left++;
            }
            result += right-left+1;
        }
        return result;
    }
}