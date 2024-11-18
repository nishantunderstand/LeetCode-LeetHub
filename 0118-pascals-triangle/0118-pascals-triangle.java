class Solution {
    public List<List<Integer>> generate(int numRows) {
        return bruteForce(numRows);
    }
    // Monday, November 18, 2024 8:36:36 PM
    // T.C - O(n^2) | S.C - O(n)
    public List<List<Integer>> bruteForce(int numRows){        
        List<List<Integer>> res = new ArrayList<>();
        if(numRows<=0)return res;        
        if(numRows==1)return Arrays.asList(Arrays.asList(1));
        
        int row = numRows;
        for(int i=0;i<row;i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==i||j==0){
                    curr.add(1);
                }else{
                    int val = res.get(i-1).get(j-1) + res.get(i-1).get(j);
                    curr.add(val);
                }
            }
            res.add(curr);
        }
        return res;
    }
}