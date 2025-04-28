// LeetCode 151
class Solution {
    public String reverseWords(String s) {    
        return stringInBuildMethod(s);
    }


    // Thursday, March 20, 2025 6:11:18 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private String stringInBuildMethod(String s) {
        // Trim leading/trailing spaces and split by one or more spaces
        String[] input = s.trim().split("\\s+");
        StringBuilder rev = new StringBuilder();
        // Iterate From Reverse Order
        for(int i=input.length-1;i>=0;i--){ //<--
            rev.append(input[i]);
            if(i>0) rev.append(" "); // Add Space Between Word //<--
        }
        return rev.toString();
    }    
}