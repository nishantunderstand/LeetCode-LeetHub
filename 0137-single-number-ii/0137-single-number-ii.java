class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        if(nums==null||n==0){
            return 0;
        }

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        /**  Fix Or Find the Mistake
        Integer res = 0;
        for(Integer ival : hm.values()){
            if(ival==1){
                return hm.get(ival);
            }
        } 
        
         for(Map.Entry<Integer,Integer> entry:hm.entrySet() ){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        } 
        */
        for(int ikey : hm.keySet()){
            if(hm.get(ikey)==1){
                return ikey;
            }
        }      
        return -1;
    }
}