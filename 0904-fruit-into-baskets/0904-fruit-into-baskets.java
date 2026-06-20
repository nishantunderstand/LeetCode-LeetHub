class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        Map<Integer, Integer> fMap = new HashMap<>();
        int windowStart = 0;

        for(int windowEnd=0;windowEnd<fruits.length;windowEnd++){
            int right = fruits[windowEnd];
            fMap.put(right,fMap.getOrDefault(right,0)+1);

            while(fMap.size()>2){
                int left = fruits[windowStart];
                fMap.put(left,fMap.get(left)-1);
                if(fMap.get(left)==0){
                    fMap.remove(left);
                }
                windowStart++;
            }            
            maxFruits = Math.max(maxFruits,windowEnd-windowStart+1);                        
        }
        return maxFruits;
    }
}