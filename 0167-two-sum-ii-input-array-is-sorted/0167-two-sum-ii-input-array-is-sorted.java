// LeetCode 167
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //return twoPointerApproach(numbers,target);
        //return binarySearchApproach(numbers,target);
        return hashMapApproach(numbers,target);
    }
    
    private int[] hashMapApproach(int[] nums, int k) {
        // Sum , Index
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(k-nums[i])){
                return new int[]{hm.get(k-nums[i])+1, i+1};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }

    // [2,7,11,15], target = 9 
    private int[] binarySearchApproach(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int j = bsearch(nums,k-nums[i], i+1); //<--
            if(j!=-1){
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{};
    }
    private int bsearch(int[] A,int key,int start){
        int L=start,R = A.length-1;
        while(L<=R){
            int M = L + (R-L)/2;
            if(A[M]==key){
                return M;  
            }else if (A[M]<key){
                L = M+1;
            }else{
                R = M-1;
            }
        }
        return -1;
    }

    // 1 Based Indexing
    private int[] twoPointerApproach(int[] nums, int k) {
        int i=0,j=nums.length-1;
        while(i<j){
            int sum = nums[i] + nums[j];
            if(sum<k){
                i++;
            }else if(sum>k){
                j--;
            }else{
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{}; //<--
    }
}