// Leetcode : 1
class Solution {    
    public int[] twoSum(int[] nums, int target) {
        //return pairApproach(nums,target);
        //return hashMapApproach(nums,target);
        return twoPointerApproach(nums,target);
    }


    // Tuesday, February 18, 2025 7:45:36 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(n)
    public int[] twoPointerApproach(int[] nums, int target) {
        int len = nums.length;
        int res[] = new int[]{-1,-1};
        if(nums==null || len<2) return res;
        
        int[][] indexNum = new int[len][2];
        
        for(int i=0;i<len;i++){
            indexNum[i]=new int[]{nums[i],i};
        }
        
        //Arrays.sort(indexNum,(a,b)->(a[0],b[0]))); // WRONG
        Arrays.sort(indexNum,(a,b)->Integer.compare(a[0],b[0]));

        int lo = 0;
        int hi = len-1;

        while(lo<hi){
            int csum = indexNum[lo][0] +indexNum[hi][0];
            if(csum==target) return new int[]{indexNum[lo][1],indexNum[hi][1]};
            if(csum<target) lo++;
            else{
                hi--;
            }
        }
        return res;
    }

    public int[] twoPointerApproachWRONG(int[] nums, int target) {
        int len = nums.length;
        int res[] = new int[]{-1,-1};
        if(nums==null || len<2) return res;
        Arrays.sort(nums); // WRONG YOU CANNOT SORT IT 

        int lo = 0;
        int hi = len-1;

        while(lo<hi){
            int csum = nums[lo]+nums[hi];
            if(csum==target) return new int[]{lo,hi};
            if(csum<target) lo++;
            else{
                hi--;
            }
        }
        return res;
    }

    // Tuesday, February 18, 2025 7:45:36 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int[] hashMapApproach(int[] nums, int target) {
        int len = nums.length;
        int res[] = new int[]{-1,-1};
        if(nums==null || len<2) return res;

        // Sum , Index
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<len;i++){
            int complement = target - nums[i];
            if(hm.containsKey(complement)){
                return new int[]{hm.get(complement),i};
            }
            hm.put(nums[i],i);
        }
        return res;
    }
        
    class Pair implements Comparable<Pair> {
        int val;
        int idx;
        
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        @Override
		public int compareTo(Pair o) {
            return this.val - o.val;
        }

		
    }
 
    

    public int[] pairApproach(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        int[] res = new int[2];
        int li = 0;
        int ri = pairs.length - 1;
        while (li < ri) {
            int left = pairs[li].val;
            int right = pairs[ri].val;
            if (left + right < target) {
                li++;
            } else if (left + right > target) {
                ri--;
            } else {
                res[0] = pairs[li].idx;
                res[1] = pairs[ri].idx;
                break;
            }
        }
        return res;
    }
}