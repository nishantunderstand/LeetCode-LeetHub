/** 
Create HashMap
Key , Value 
If the Value of hashmap are unique, then return true else return false
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        // Iterator<Integer> hmValues = map.values().iterator();, This is used to Check 
        //Arrays.sort(hmValues);// No Need 
        
        HashSet<Integer> hs = new HashSet<>(hm.values()); // We can Directly Created
        /**
        for(int i=0;i<hmValues.length;i++){
            hs.add(hs[i]);
        }
        if(hs.size()==hmValues.length){
            return true;
        }else{
            return false;
        }
        */
        return hs.size()== hm.size();
    }
}


