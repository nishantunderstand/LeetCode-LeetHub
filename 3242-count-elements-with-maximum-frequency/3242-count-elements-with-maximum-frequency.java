class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();        
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(Integer ival : hm.values()){
            max = Math.max(max,ival);                        
        }

        for(Integer ival : hm.values()){        
            if(ival==max){ // ival>=max // WRONG
                count +=ival;
            }            
        }
        return count;
    }
}