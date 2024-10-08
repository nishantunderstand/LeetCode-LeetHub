/** 
Given an integer n, return the number of prime numbers that are strictly less than n.
You need to count upto n-1, that why we are using upto n
TC - nloglogn
SC - n
*/

class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int count = 0;
        int[] isPrime = new int[n];
        Arrays.fill(isPrime,1);
        isPrime[0]=0;
        isPrime[1]=0;
        for(int i=2;i*i<n;i++){
            if(isPrime[i]==1){
                for(int j=i*i;j<n;j=j+i){
                    isPrime[j]=0;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(isPrime[i]==1){
                count++;
            }
        }
        return count;        
    }
}