// LeetCode : 1482
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        //return bruteForce(bloomDay,m,k);   
        return binarySearch(bloomDay,m,k);   
    }

    // TC : O(n * log(maxDay - minDay))
    // SC : O(1)
    private int binarySearch(int[] bloomDay, int m, int k){
        if( 1L*m*k> bloomDay.length) return -1; 
        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int num : bloomDay){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }

        int low = min;
        int high = max;

        while(low<high){
            int mid = low + (high-low)/2;
            if(isPossible(bloomDay, m, k , mid)){
                high=mid; //<--
            }else{ 
                low = mid+1;
            }
        }
        return low;
    }


    // TLE 
    // Saturday, June 27, 2026 10:27:26 AM
	// TC : O(n) | SC : O(1)
    public int bruteForce(int[] bloomDay, int m, int k) {
        // Invalid Days
        
        
        // Finding Min and Max

        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int num : bloomDay){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }

        for(int day=min;day<=max;day++){
            if(isPossible(bloomDay,m,k,day)){
                return day;
            }
        }
        return -1;
    }

    // TC : O(n) | SC : O(1)
    private boolean isPossible(int[] bloomDay, int m, int k, int day){
        int noOfB = 0;
        int cnt = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                cnt++;
            }else{
                noOfB += (cnt/k);
                cnt = 0;
            }
        }
        noOfB += (cnt/k); //<--
        return noOfB>=m;
    }

}