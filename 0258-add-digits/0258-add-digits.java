class Solution {
    public int addDigits(int num) {
        return recursiveApproach(num);
        //return directFormula(num);
    }

    // Sunday, January 5, 2025 8:51:12 PM
    // Time Complexity:O(1) | Space Complexity:O(1)
    public int directFormula(int num) {
        if(num==0) return 0;
        return num%9==0?9:num%9;
    }
    // Sunday, January 5, 2025 8:51:17 PM
    // Time Complexity:O(logn) | Space Complexity:O(logn)
    public int recursiveApproach(int num) {
        if(num<10) return num;
        int digitSum=0;
        while(num>0){
            digitSum=digitSum+num%10;
            num=num/10;
        }
        return recursiveApproach(digitSum);
    }

}