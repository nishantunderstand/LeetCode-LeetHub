
class Solution {
    public double myPow(double x, int n) {
        return bruteForce(x, n);
        // return iterative(x, n);
        // return recursive(x, n); /
        // return recursiveMod(x, n);
        // return recursiveFastExponent(x, n);
    }

    public double recursiveFastExponent(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double half = 0.0;
        double halfSquared = 0.0;
        if (n % 2 == 0) {
            half = recursiveFastExponent(x, n / 2);
            halfSquared = half * half;
            return halfSquared;
        } else {
            return halfSquared * half;
        }
    }

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

    public double recursive(double x, int n) {
      if (n == 0) {
      return 1.0;
      }
      if (n < 0) {
      x = 1 / x;
      n = -n;
      }
      if (n % 2 == 0) {
      return recursive(x, n / 2)*recursive(x, n / 2);
      } else {
      return recursive(x, n / 2)*recursive(x, n / 2)* x;
      }
      }

    public double iterative(double x, int n) {
        if (n % 2 == 0) {

        }
        return 0;
    }

    public double bruteForce(double x, int n) {
        return Math.pow(x, n);
    }
}