class Solution {
    public List<Integer> lexicalOrder(int n) {
        // return dfsApproach(n);
        return stringApproach(n);
    }
    public List<Integer> stringApproach(int n) {
        List<String> curr = new ArrayList<>();
        for(int i=1;i<=n;i++){
            curr.add(String.valueOf(i));
        }

        Collections.sort(curr);
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<curr.size();i++){
            result.add(Integer.parseInt(curr.get(i)));
        }
        return result;
    }

    public List<Integer> dfsApproach(int n) {
       List<Integer> res = new ArrayList<>();
       for(int i=1;i<=9;i++) {
        solve(i,n,res);
       }
       return res;
    }

    public void solve(int curr,int n,List<Integer> res){
        if(curr>n) return;
        res.add(curr);

        for(int i=0;i<=9;i++){
            int nextNo = curr*10+i;
            if(nextNo>n) return;
            solve(nextNo,n,res);
        }
    }
}

/**
[1, n] sorted in lexicographical order.
    Does this mean 1 based Indexing ?

*/