// Friday, June 5, 2026 11:54:37 PM
// TC : O(n) | SC : O(1)
// LeetCode : 1299
class Solution {
    public int[] replaceElements(int[] arr) {
       int n = arr.length;
       int[] res = new int[n];
       int maxFromRight=-1;

       for(int i=n-1;i>=0;i--){
        res[i] = maxFromRight;
        maxFromRight = Math.max(maxFromRight,arr[i]);        
       }
       return res;
    }
}
