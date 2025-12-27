// LeetCode : 56
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(intervals==null ||n ==0){
            return new int[0][0];
        }
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int s1 = intervals[0][0];
        int e1 = intervals[0][1];        
        for(int i=1;i<n;i++){
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];
            if(s2<=e1){
                e1 = Math.max(e1,e2);  //<--
            }else{
                merged.add(new int[]{s1,e1});
                s1 = s2;
                e1 = e2;
            }
        }
        // How to add Array in A LinkedList 
        merged.add(new int[]{s1,e1});
        
        // Convert LinkedList to Array and return , You need to learn [[Anki]]
        return merged.toArray(new int[merged.size()][]);        
    }
}