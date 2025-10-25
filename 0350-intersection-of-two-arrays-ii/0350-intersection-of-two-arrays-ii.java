// LeetCode : 350
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //return hashSetApproachWorksForUniqueOnly(nums1,nums2);
        return hasMapApproach(nums1,nums2);
    }
    public int[] hasMapApproach(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        
        // Push All nums1 -> hm1 
        for(int i=0;i<nums1.length;i++){
            hm1.put(nums1[i], hm1.getOrDefault(nums1[i],0)+1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        // Iterate Over nums2 & Check Is it Present or Not 
        for(int i=0;i<nums2.length;i++){
            // if(hm1.get(nums2[i])> 0 && hm1.containsKey(nums2[i])){ // WRONG
            if(hm1.containsKey(nums2[i]) && hm1.get(nums2[i])> 0 ){ //<--
                result.add(nums2[i]);
                hm1.put(nums2[i], hm1.get(nums2[i])-1); //<--
            }
        }   

        // ArrayList to Array
        int[] resArr = new int[result.size()];
        for(int i=0;i<result.size();i++){
            resArr[i]=result.get(i);
        }
        return resArr;        
    }


    // Failed I need Duplicate
    public int[] hashSetApproachWorksForUniqueOnly(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        HashSet<Integer> resultSet = new HashSet<>();
        for(int num : nums2){
            if(set1.contains(num)){
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
}

/**
    What if Number are Greater than 10 ?
    How will you handle it ?
*/
