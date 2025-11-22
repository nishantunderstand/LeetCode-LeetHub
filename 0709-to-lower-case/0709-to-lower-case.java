// LeetCode : 709
class Solution {
    public String toLowerCase(String s) {
        // return inBuildMethod(s);
        return charBycharChange(s);
    }

    // Sunday, November 23, 2025 12:04:52 AM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private String charBycharChange(String str){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr>='A' && curr<='Z'){
                curr = (char)(curr+32);  //<--  LowerCase to UpperCase             
            }
            sb.append(curr);  //<--
        }
        return sb.toString();
    }
    
    // Sunday, August 3, 2025 2:29:52 PM
    // Time Complexity:O(n) | Space Complexity:O(1)    
    public String inBuildMethod(String s) {
        return s.toLowerCase();
    }
}