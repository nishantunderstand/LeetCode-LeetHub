// LeetCode : 907
class Solution {    
    public int sumSubarrayMins(int[] arr) {
        return stackApproach(arr);
        //return bruteForce(arr);
    }
    // Tuesday, June 16, 2026 9:35:50 PM
    // TC : O(n) | SC : O(n)
    public int stackApproach(int[] arr) {
        int MOD = 1_000_000_007;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        int n = arr.length;
        long total = 0; 
        for(int i=0;i<n;i++){
            long left = i - psee[i];
            long right = nse[i] - i;    

            //long contribution =(arr[i] * left % MOD)* right % MOD;
            //total = (total + contribution) % MOD;

            total =  (total + ((left*right)%MOD * arr[i]) %MOD) %MOD; //<--
            //total = (total + ((right*left)%MOD * arr[i]) %MOD)%MOD;            
        }
        return (int) total;
    }

    // TC : O(n) | SC : O(n)
    private int[] findNSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){ //<--
                st.pop();
            }
            nse[i] = st.isEmpty()?n:st.peek(); //<--
            st.push(i);
        }
        return nse;
    }

    // TC : O(n) | SC : O(n)
    private int[] findPSEE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] psee = new int[n];
        for(int i=0;i<n;i++){ //<--
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){ //<--
                st.pop();
            }
            psee[i] = st.isEmpty()?-1:st.peek(); //<--
            st.push(i);
        }
        return psee;
    }

    // TLE
    public int bruteForce(int[] arr) {
        int n = arr.length;
        int MOD = 1000*1000*1000+7;
        int sum = 0;
        
        for(int i=0;i<n;i++){
            int min=arr[i];
            for(int j=i;j<n;j++){
                min = Math.min(min,arr[j]);                
                sum = (sum+min)%MOD;
            }
        }
        return sum;
    }
}

// Previous Smaller        -> >
// Next Smaller Or Equal   -> >=