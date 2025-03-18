// Leetcode : 9

// Tuesday, March 18, 2025 7:57:09 PM
// Time Complexity:O(n) | Space Complexity:O(1)
class Solution {
    public boolean isPalindrome(int x) {
        if(x==0) return true;
        if(x<0) return false;
        int xcopy = findreverse(x);
        return x==xcopy;
    }

    // Time Complexity:O(n) | Space Complexity:O(1)
    private int findreverse(int x){
        int rev = 0;
        while(x>0){
            rev = rev*10 + x%10;
            x =x/10;
        }
        return rev;
    }
}


/**
Positive => 
121 
find its reverse


Negative => Not Palindrome
-1 => 1-
-10 => 01-


Zero => Yes


*/