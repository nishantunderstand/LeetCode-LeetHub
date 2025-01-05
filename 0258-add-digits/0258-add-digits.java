class Solution {
    public int addDigits(int num) {
        //return recursiveApproach(num);
        return directFormula(num);
    }
    public int directFormula(int num) {
        if(num==0) return 0;
        return num%9==0?9:num%9;
    }

    public int recursiveApproach(int num) {
        if(num<10) return num;
        int digitSum=0;
        while(num>=9){
            digitSum=digitSum+num%10;
            num=num/10;
        }
        return recursiveApproach(digitSum);
    }

}