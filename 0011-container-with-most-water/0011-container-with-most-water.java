// Leetcode : 11
class Solution {
    public int maxArea(int[] height) {
        //return bruteForce(height);
        return twoPointer(height);
    }

    // Friday, January 3, 2025 11:10:16 AM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int twoPointer(int[] height) {        
        int mArea=0;
        if(height==null || height.length<2) return mArea;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int wid = right-left;
            int heig = Math.min(height[left],height[right]);
            int cArea = wid*heig;
            mArea = Math.max(cArea,mArea);
            if(height[left]<height[right]) left++;
            else right--;
        }
        return mArea;
    }

    // Friday, January 3, 2025 11:02:15 AM
    // Time Complexity:O(n^2) | Space Complexity:O(1)
    // TLE
    public int bruteForce(int[] height) {
        int maxArea=0;
        if(height==null || height.length==0) return maxArea;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int w = j-i;
                int h = Math.min(height[i],height[j]);
                int cArea = h*w;
                maxArea=Math.max(cArea,maxArea);
            }
        }
        return maxArea;
    }
}
