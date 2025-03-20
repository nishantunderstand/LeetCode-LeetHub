/** 
Create HashMap => Key , Value 
If the Value of hashmap are unique, then return true else return false

[1,2,2,1,1,3]
1 - 3
2 - 2
3 - 1
Everything is Distinct | Return True

[1,2]
1 - 1
2 - 1
Same | Return False

*/

// Leetcode : 1207
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //return hashMapAndHashSet(arr);
        return hashMapAndHashSetMOD(arr);

    }
    // Friday, February 7, 2025 5:54:15 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public boolean hashMapAndHashSetMOD(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }        
        HashSet<Integer> hs = new HashSet<>(hm.values()); //<--
        return hs.size()== hm.size(); //<---
    }

    // [1,2,2,1,1,3]
    // 1-3, 2-2, 3-1
    public boolean hashMapAndHashSet(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> hs = new HashSet();
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(hs.contains(entry.getValue())){
                return false;
            }
            hs.add(entry.getValue());
        }
        return true;       
    }
}


