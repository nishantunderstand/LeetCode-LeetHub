/**
Invalid Input Edge Cases

s1,e1
s2,e2

Overlap - e1>s2  ==> s1,e2

Assumptions : Intervals are sorted.
If they are not sorted, Then you need to sort them.
Do i need to sort ??






*/
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(intervals==null ||n ==0){
            return new int[0][0];
        }

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        int row = intervals.length;
        int col = intervals[0].length;

        LinkedList<int[]> merged = new LinkedList<>();

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        
        for(int i=1;i<n;i++){
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];
            if(e1>=s2){
                e1 = Math.max(e1,e2);
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