// LeetCode : 3270
class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int[] num1a = new int[4];
        int[] num2a = new int[4];
        int[] num3a = new int[4];
        int[] res = new int[4];
        int n=4;
        Arrays.fill(num1a,0);
        Arrays.fill(num2a,0);
        Arrays.fill(num3a,0);
        Arrays.fill(res,0);
        for(int i=0;i<n;i++){
            num1a[n-1-i]=num1%10; 
            num1=num1/10;
        }
        for(int i=0;i<n;i++){
            num2a[n-1-i]=num2%10; 
            num2=num2/10;
        }
        for(int i=0;i<n;i++){
            num3a[n-1-i]=num3%10; 
            num3=num3/10;
        }        
        for(int i =0;i<n;i++){
            res[i]=Math.min(num1a[i],Math.min(num2a[i],num3a[i]));
        }
        int ans =0;
        for(int i=0;i<n;i++){
            ans = ans*10 + res[i];
        }
        return ans;        
    }
}