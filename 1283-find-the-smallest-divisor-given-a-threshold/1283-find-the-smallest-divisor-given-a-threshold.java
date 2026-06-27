// LeetCode : 1283
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //return bruteForce(nums,threshold);
        return binarySearch(nums,threshold);
    }

    // Saturday, June 27, 2026 11:29:17 AM
	// TC : O(log(max(nums)) * n) | SC : O(1)
    private int binarySearch(int[] nums, int threshold){
        int low = 1;
        int high = nums[0];
        for(int num : nums){
            high = Math.max(high,num);
        }
        while(low<high){
            int mid = low + (high-low)/2;
            if(isPossible(nums,threshold,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean isPossible(int[] nums, int threshold, int div){
        int sum = 0;
        for(int num : nums){
            sum += (num + div-1)/div;
            if(sum>threshold) return false;
        }
        return true;
        //return sum<=threshold; // Optimization Approach
    }


    // TLE     
	// Saturday, June 27, 2026 11:29:17 AM
	// TC : O(max * n) | SC : O(1)
    private int bruteForce(int[] nums, int threshold){
        int low = 1;
        int high = nums[0];
        for(int num : nums){
            high = Math.max(high,num);
        }
        // Identify the range
        for(int div=low;div<=high;div++){
            int sum  = 0;
            
            // Calcuate the sum
            for(int num : nums){
                sum += (num + div-1)/div; // Ceil Division
            } 
            if(sum<=threshold){
                return div; //<--
            }   
        }
        return -1;
    }
}