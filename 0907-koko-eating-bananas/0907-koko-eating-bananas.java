// LeetCode 875
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;

        for(int pile : piles)
            maxSpeed = Math.max(maxSpeed,pile);        

        while(minSpeed<maxSpeed){
            int midSpeed = minSpeed + (maxSpeed-minSpeed)/2;            
            if(canEat(midSpeed,piles,h)){
                // She can Eat, Try Slower
                maxSpeed = midSpeed;            
            }else{
                // Need to Eat Faster
                minSpeed = midSpeed+1;
            }
        }
        return minSpeed;
    }
    public boolean canEat(int speed,int [] piles,int h){
        int hours = 0;         
        for(int pile : piles ){
            hours += (pile+speed-1)/speed;
        }
        return hours<=h;
    }


    public boolean canEatDoubleVersion(int speed,int [] piles,int h){
        int hours = 0;         
        for(int pile : piles ){
            hours += (int) Math.ceil((double) pile/speed);
        }
        return hours<=h;
    }

    // Integer ceiling trick (pile + speed - 1) / speed avoids Math.ceil and floating-point arithmetic.
}