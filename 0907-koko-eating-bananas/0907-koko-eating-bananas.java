// LeetCode 875
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int max = Integer.MIN_VALUE;
        int len = piles.length;

        for(int i=0;i<len;i++){
            max = Math.max(max,piles[i]);
        }
        int high = max;
        int potAns = max;

        while(low< high){
            int mid = low + (high-low)/2;

            if(canEat(mid,piles)<=h){
                potAns = mid;
                high = mid; //<--
            }else{
                low = mid+1;
            }
        }
        return potAns;
    }
    public int canEat(int mid,int [] piles){
        int hours = 0; // <- Hours Cannot be Double
        int len = piles.length;
        for(int i=0;i<len;i++){
            hours += (int) Math.ceil((double) piles[i]/mid);
        }
        return hours;
    }
}