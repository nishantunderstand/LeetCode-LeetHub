// LeetCode : 658 
// Brute Force Approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                int diff =  Integer.compare(Math.abs(b-x),Math.abs(a-x));
                // Handle Tie Breaker 
                if(diff==0) return Integer.compare(b,a);
                return diff;
            }
        });
        

        for(int num : arr){
            maxPQ.offer(num);

            if(maxPQ.size()>k){
                maxPQ.poll();
            }
        }

        List<Integer> res = new ArrayList<>(maxPQ);
        Collections.sort(res);
        return res;
    }
}