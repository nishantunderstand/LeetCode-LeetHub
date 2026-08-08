// LeetCode : 202
class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean isHappy(int n) {
        return isHappyRec(n);
    }
    public boolean isHappyRec(int n){
        if(n==1) return true;
        if(visited.contains(n)) return false;
        visited.add(n);
        int sum = 0;
        while(n!=0){
            int rem = n%10;
            sum += rem*rem;
            n=n/10;
        }
        return isHappyRec(sum);
    }    
}
