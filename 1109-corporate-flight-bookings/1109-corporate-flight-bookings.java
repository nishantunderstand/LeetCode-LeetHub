// LeetCode : 1109
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        return arrayDiffernce(bookings,n);                  
    }

    // Saturday, December 27, 2025 1:11:52 PM
    // Time Complexity:O(n + bookings.length) | Space Complexity:O(n)
    private int[] arrayDiffernce(int[][] bookings, int n) {
        int[] diff = new int[n];
        for(int i=0;i<bookings.length;i++){
            int li = bookings[i][0]-1;
            int ri = bookings[i][1]-1;
            int val = bookings[i][2];

            diff[li] += val;
            if(ri+1<n){
                diff[ri+1] -= val;
            }
        }
        for(int i=1;i<n;i++){
            diff[i] = diff[i] + diff[i-1];
        }  
        return diff;                  
    }
}

// 1 <= firsti <= lasti <= n : 1 Based Indexing