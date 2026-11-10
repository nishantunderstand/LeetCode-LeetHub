// LeetCode : 119
// Tuesday, November 10, 2026 12:53:37 PM    
// TC : O(n*n) | SC : O(n)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        for(int C=1;C<=rowIndex+1;C++){ //<--
            res.add(findNCR(rowIndex,C-1));
        }
        return res;
    }


    // TC : O(r) | SC : O(1)
    private int findNCR(int n, int r){
        long ans=1;
        for(int i=0;i<r;i++){
            ans = ans * (n-i) / (i+1);
        }
        return (int) ans;
    }
}