/**
Checking Each Item, Linear Search
Hashing 
    HashMap - LinkedHashMap 
        If Negative - Don't Store them
        Iterate Over Key , Check For Missing One 
    HashSet  - LinkedHashSet
        If Negative - Don't Store them
        Iterate Over Key , Check For Missing One 
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        return hashSetApproach(nums);
    }
    public int hashSetApproach(int[] nums) {
        int len = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        // Adding All the Element to HashSet
        for(int i=0;i<len;i++){
            hs.add(nums[i]);
        }
        // Checking for Missing Positive, Count From 1 to n+1
        for(int i=1;i<=len+1;i++){ //<--
            if(!hs.contains(i)) return i;
        }
        return -1;
    }

}