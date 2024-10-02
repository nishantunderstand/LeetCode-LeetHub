/**
Tuesday, October 1, 2024 11:31:57 PM
T.C - O(n^2)
S.C - O(n^2)
*/


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> al = new ArrayList<>();
        if(numRows<=0){
            return al;
        }
        
        if(numRows==1){
            return Arrays.asList(Arrays.asList(1));
        }
        
        int row = numRows;
        for(int i=0;i<row;i++){
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==i||j==0){
                    res.add(1);
                }else{
                    int val = al.get(i-1).get(j-1) + al.get(i-1).get(j);
                    res.add(val);
                }
            }
            al.add(res);
        }
        return al;
    }
}