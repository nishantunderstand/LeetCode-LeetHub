// LeetCode : 977
class Solution {
    public int[] sortedSquares(int[] nums) {
        //return streamApproach(nums);
        return twoPointerApproach(nums);
    }  

    // Saturday, December 27, 2025 5:36:11 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private int[] twoPointerApproach(int[] nums){
        int n = nums.length;
        int[] res = new int[n];

        int left = 0;
        int right = n-1;
        int index = n-1;

        while(left<=right){
            int leftSq = nums[left]*nums[left];
            int rightSq = nums[right]*nums[right];
            if(leftSq<rightSq){ //<--
                res[index]=rightSq;
                index--;
                right--;
            }else{
                res[index] = leftSq;
                index--;
                left++;
            }
        }
        return res;
    }

    // Monday, December 22, 2025 9:55:47 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(n)
    public int[] streamApproach(int[] nums) {
        return Arrays.stream(nums)
        .map(n->n*n)
        .sorted()
        .toArray();
    }
}