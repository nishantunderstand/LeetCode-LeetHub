// LeetCode: 349
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        return hashMapApproach(nums1,nums2);
        //return hashSetApproach(nums1,nums2);
    }

    private int[] hashSetApproach(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        for(int num:nums2){
            if(set.contains(num)){
                resultSet.add(num);
            }
        }
        // HashSet -> Array
        int idx=0;
        int[] result = new int[resultSet.size()];
        for(int num:resultSet){
            result[idx++]=num;
        }
        return result;
    }

    
    private int[] hashMapApproach(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        // Approach A
        /**
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
        */

         // Approach B
        for(int i=0;i<nums1.length;i++){
           hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
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