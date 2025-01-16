/**
I create HashMap
I need Element with Freq ==1
Edge Case 0 1
*/
class Solution {
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int csum=0;
        for(int ikey : hm.keySet()){
            if(hm.get(ikey)==1){ // I want to compare Key should be 1
                //csum += hm.get(ikey); // No, You need to Add Key
                csum+=ikey;
            }
        }
        return csum;
    }
}