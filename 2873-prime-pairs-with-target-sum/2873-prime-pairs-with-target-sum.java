class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        return sieveApproach(n);
    }

    // Tuesday, January 28, 2025 10:00:42 PM
    // Time Complexity:O(nloglogn) | Space Complexity:O(n)
    public List<List<Integer>> sieveApproach(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<=2) return res; 
                      
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;

        for(int i=2;i*i<=n;i++){ //<--
            if(isPrime[i]){
                for(int j=i*i;j<=n;j=j+i){
                    isPrime[j]=false; //<--
                }
            }
        }
        for(int i=2;i<=n/2;i++){ //<--
            if(isPrime[i]==true && isPrime[n-i]==true){
                List<Integer> curr = new ArrayList<>();
                curr.add(i);
                curr.add(n-i);
                res.add(curr);
            }            
        }
        return res;
    }
}