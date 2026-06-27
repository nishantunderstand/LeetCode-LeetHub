// LeetCode : 1011
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        return binarySearch(weights,days);
        //return bruteForce(weights,days);
    }

    // TLE 
    // Saturday, June 27, 2026 12:15:54 PM
	// TC : O(n*sum(weights)) | SC : O(1)
    private int bruteForce(int[] weights, int days){
        int low = 0; // Max Element 
        int high = 0; // Total Sum
        for(int wgt : weights){
            low = Math.max(wgt,low);
            high += wgt;
        }

        for(int cap=low;cap<=high;cap++){
            int reqDay = calculateDays(weights,cap);
            if(reqDay<=days) return cap;
        }
        return -1;
    }

    // Saturday, June 27, 2026 1:09:56 PM
	// TC : O(n) | SC : O(1)
    private int calculateDays(int[] weights, int cap){
        int reqDay = 1; //<-- Why Default 1
        int currLoad = 0;
        for(int wgt : weights){
            if(currLoad + wgt > cap){
                reqDay++;
                currLoad = wgt;
            }else{
                currLoad += wgt;
            }
        }
        return reqDay;
    }



	// Saturday, June 27, 2026 11:54:38 AM
	// TC : O(n*log(sum(weights)) | SC : O(1)
    private int binarySearch(int[] weights, int days){
        int low = 0; // Max Element 
        int high = 0; // Total Sum
        for(int wgt : weights){
            low = Math.max(wgt,low);
            high += wgt;
        }

        while(low<high){
            int mid = low + (high-low)/2;
            int reqDay = calculateDays(weights,mid); //<--
            if(reqDay<=days){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    
}
