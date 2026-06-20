class Solution {
    public boolean consecutiveSetBits(int n) {
         // Create a list => Binary to Integer 
        // Then Check for Duplicate

        List<Integer> res = binaryToArray(n);

        // Find Count of 
        int cnt = 0;
        for(int i=1;i<res.size();i++){
            if(res.get(i)==1 && res.get(i-1)==1){
                cnt++;
            }
        }
        return cnt==1;

        // As you need to check Count,
    }

    private List<Integer> binaryToArray(int n){
        List<Integer> res = new ArrayList<>();
        while(n>0){
            res.add(n%2); //<--
            n=n/2;
        }
        Collections.reverse(res);
        return res;
    }
}