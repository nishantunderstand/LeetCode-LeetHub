class Solution {
    public double myPow(double x, int n) {
        return bruteForce(x,n);
    }

    public double bruteForce(double x, int n) {
        return Math.pow(x,n);
    }
}