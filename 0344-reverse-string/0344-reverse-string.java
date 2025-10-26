// LeetCode : 344
class Solution {
    public void reverseString(char[] s) {
        inplaceApproach(s);
    }
    
    // Sunday, October 26, 2025 2:17:14 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public void inplaceApproach(char[] s) {
        int low = 0;
        int high = s.length - 1;
        while(low<=high){
            char temp = s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;
            high--;
        }
    }
}