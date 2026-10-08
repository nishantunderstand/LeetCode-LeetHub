class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int L = 0;
        int R = letters.length-1;

        // Lower Bound 

        while(L<=R){
            int M = L + (R-L)/2;
            if(letters[M]>target){ // I need Greater Element 
                R = M-1;
            }else{
                L = M+1;
            }
        }
        return letters[L%letters.length];
    }
}
// LeetCode : 744