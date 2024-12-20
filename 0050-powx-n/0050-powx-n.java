class Solution {
    public double myPow(double x, int n) {
        // return bruteForce(x, n);
        // return iterative(x, n); // Pending
        // return recursive(x, n); // TLE
        // return recursiveMod(x, n); // RunTime Error
        // return recursiveModAdv(x, n); // RunTime Error
        return recursiveFinal(x, n);
    }

    public double recursiveFinal(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            if(n==Integer.MIN_VALUE){
                return x* 1/recursiveFinal(x,Integer.MAX_VALUE);
            }
            x = 1 / x;
            n = -n;
        }
        double half = recursiveMod(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    // RunTime Error
    public double recursiveModAdv(double x, int n) {
        long N = (long) n;
        if (N == 0) {
            return 1.0;
        }
        if (x == 0) {
            return 0.0;
        }

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double half = recursiveModAdv(x, (int) N / 2);
        if (N % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    // RunTime Error
    public double recursiveMod(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double half = recursiveMod(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    // TLE
    public double recursive(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            return recursive(x, n / 2) * recursive(x, n / 2);
        } else {
            return recursive(x, n / 2) * recursive(x, n / 2) * x;
        }
    }

    // IDK
    public double iterative(double x, int n) {
        if (n % 2 == 0) {

        }
        return 0;
    }

    public double bruteForce(double x, int n) {
        return Math.pow(x, n);
    }
}
