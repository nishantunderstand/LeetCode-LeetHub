class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<nums1.length;i++){
           int key = nums1[i];
            if(hm.containsKey(key)){
                int oldFreq = hm.get(key);
                int newFreq = oldFreq+1;
                hm.put(key,newFreq);
            }else{
                hm.put(key,1);
            }
        }

        for(int i=0;i<nums2.length;i++){
            int val = nums2[i];
            if(hm.containsKey(val)){
                res.add(val);
                hm.remove(val);
            }
        }
        
        // ArrayList to Array 
        // Step 1
        // return res.stream().mapToInt(Integer::intValue).toArray();

        // Step 2
        int[] resArray = new int[res.size()];
        for(int i=0;i<resArray.length;i++){
            resArray[i]=res.get(i);
        }
        return resArray;
    }
    
}