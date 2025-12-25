// LeetCode : 852
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       return binarySearchApproach(arr);
    }
    // Thursday, December 25, 2025 3:31:49 PM
    // Time Complexity:O(logn) | Space Complexity:O(1)
    public int binarySearchApproach(int[] arr) {
        int start = 0;
        int end = arr.length-2;  //<--
        while(start<end){
            int mid = start + (end-start)/2;
            // Increasing Slope
            if(arr[mid]<arr[mid+1]){
                start = mid+1;
            }
            // Decreasing Slope
            else{
                end = mid;
            }
        }
        return start;
    }
}