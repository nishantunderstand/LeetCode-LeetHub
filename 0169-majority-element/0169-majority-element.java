// LeetCode : 169
class Solution {
    public int majorityElement(int[] nums) {
        return hashMapAppraoch(nums);        
    }
    // Thursday, February 13, 2025 2:50:03 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int hashMapAppraoch(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int target = len/2;   
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){ //<--
            if(entry.getValue()>target){ //<--
                return entry.getKey();
            }
        }
        return -1;
    }
}