// LeetCode : 986
// Sorted : Yes

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //return twoPointer(firstList, secondList);
        return smartApproach(firstList, secondList);
    }

    // Thursday, November 5, 2026 12:47:33 PM    
    // TC : O(n) | SC : O(n)
    public int[][] smartApproach(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int ptr1 = 0, ptr2 =0;
        while(ptr1 < firstList.length && ptr2 < secondList.length){
            int cSP = Math.max(firstList[ptr1][0],secondList[ptr2][0]);
            int cEP = Math.min(firstList[ptr1][1],secondList[ptr2][1]);

            if(cSP<=cEP){
                res.add(new int[]{cSP,cEP});
            }

            if(firstList[ptr1][1]<secondList[ptr2][1]){
                ptr1++;
            }else{
                ptr2++;
            }
        }   
        return res.toArray(new int[res.size()][]);
    }



    public int[][] twoPointer(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i<firstList.length && j<secondList.length){
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];

            int s2 = secondList[j][0];
            int e2 = secondList[j][1];

            int start = Math.max(s1,s2); //
            int end = Math.min(e1,e2); //

            if(start<=end){
                res.add(new int[]{start,end});
            }
            if(e1<e2){
                i++; // First One 
            }else{
                j++; // Second One 
            }        
        }
        return res.toArray(new int[res.size()][]);
    }
}