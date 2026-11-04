class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cnt = 0;
        int csum  = 0;

        int start = 0;
        for(int end=0;end<arr.length;end++){
            csum += arr[end];
            if(end-start+1==k){
                if(csum>= k*threshold){  //<--
                    cnt++;                    
                }

                csum -= arr[start];
                start++;
            }
            
        }
        return cnt;   
    }
}

// LeetCode : 1343