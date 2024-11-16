class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int n = height.length;
        // PrefixMaxOfLeft
        int[] maxLeft = new int[n];
        maxLeft[0]=height[0];
        for(int i=1;i<n;i++){
            maxLeft[i]=Math.max(maxLeft[i-1],height[i]);
        }
        // PrefixMaxOnRight
        int[] maxRight = new int[n];
        maxRight[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            maxRight[i]=Math.max(maxRight[i+1],height[i]);
        }
        for(int i=0;i<n;i++){            
            int water = Math.min(maxLeft[i],maxRight[i])-height[i];
            if(water>0){
                totalWater+=water;
            }
        }  
        return totalWater;
    }
}