class Solution {
    public List<Integer> majorityElement(int[] nums) {
        return hashMapApproach(nums);
    }

    // Thursday, February 13, 2025 2:50:03 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public List<Integer> hashMapApproach(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        if(len<0) return result;

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<len;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        int target = len/3;   
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){ //<--
            if(entry.getValue()>target){ //<--
                int item = entry.getKey();
                result.add(item);
            }
        }
        return result;
    }
}