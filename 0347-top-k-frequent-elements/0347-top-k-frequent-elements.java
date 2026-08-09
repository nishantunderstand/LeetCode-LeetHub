// LeetCode : 347
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> maxPQ = 
            new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        
        maxPQ.addAll(map.keySet());
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = maxPQ.poll();
        }

        return res;
    }
}