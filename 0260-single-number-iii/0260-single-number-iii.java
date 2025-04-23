// Leetcode : 260
class Solution {
    public int[] singleNumber(int[] nums) {
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