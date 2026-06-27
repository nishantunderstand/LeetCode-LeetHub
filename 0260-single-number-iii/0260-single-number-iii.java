// Leetcode : 260
class Solution {
    public int[] singleNumber(int[] nums) {        
        return hashMap(nums);
        //return bits(nums);
    }

    // Saturday, June 27, 2026 8:30:06 PM
	// TC : O(n) | SC : O(1)
    private int[] bits(int[] nums){
        int xor = 0;
        for(int num :  nums){
            xor ^=num;
        }
        
        int rmsb = (xor & (xor-1)) ^ xor; // xor & -xor;
        int b1 = 0; int b2 = 0;

        for(int num : nums){
            if((rmsb & num)==0){
                b1^=num;
            }else{
                b2^=num;
            }
        }
        return new int[]{b1,b2};
    }


    // Saturday, June 27, 2026 8:25:51 PM
	// TC : O(n) | SC : O(n)
    public int[] hashMap(int[] nums) {
        int n = nums.length;
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        // As we are viewing No Data Modification.
        // If you try to modify Errror, Try Iterator<Integer> it = hm.keySet().iterator();
        
        for (int ikey : hm.keySet()) {
            if (hm.get(ikey) == 1) {
                res.add(ikey);
            }
        }
        
        int[] resArr = new int[res.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}