/** 
Create HashMap
Key , Value 
If the Value of hashmap are unique, then return true else return false
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        return hashMapAndHashSet(arr);

    }

    // Friday, February 7, 2025 5:54:15 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public boolean hashMapAndHashSet(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }        
        HashSet<Integer> hs = new HashSet<>(hm.values()); 
        return hs.size()== hm.size(); //<---
    }
}


