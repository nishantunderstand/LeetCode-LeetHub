class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int index = 0;

        for(int num : nums){
            if(num<pivot){
                res[index++] = num;
            }
        }

        for(int num : nums){
            if(num==pivot){
                res[index++] = num;
            }
        }

        for(int num : nums){
            if(num>pivot){
                res[index++] = num;
            }
        }

        return res;
    }
}