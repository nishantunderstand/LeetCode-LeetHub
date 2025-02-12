/**
Remove Spaces, , Other by Regex
Convert to lowercase
Use String
Later Use StringBuilder
Learn Regex
Here we are comparing Character
*/

class Solution {
    public boolean isPalindrome(String s) {
        //return stringInBuiltMethodApproach(s);
        return pointerApproach(s);
    }

    // Tuesday, February 11, 2025 7:29:23 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public boolean pointerApproach(String str) {        
        int left = 0;
        int right = str.length() - 1;
        str=str.toLowerCase();

        while (left < right) { 
            char ch1 =str.charAt(left);
            char ch2 =str.charAt(right);
            //System.out.println("char1 : "+ch1 + " - "+  "char2 : "+ch2);

            if(!((ch1>='a' && ch1<='z') || (ch1>='0' && ch1<='9'))){ //<-- LOOK AT BRACKET && EQUALITY CONDITION
                left++;
                continue;//<-- // Skip non-alphanumeric characters
            }

            if(!((ch2>='a' && ch2<='z') || (ch2>='0' && ch2<='9'))){ //<-- LOOK AT BRACKET && EQUALITY CONDITION
                right--;
                continue;//<--
            }    
            
            if(ch1!=ch2) return false;
            left++;
            right--;

        }
        return true;
    }

    // Time Complexity:O(n) | Space Complexity:O(n)
    public boolean stringInBuiltMethodApproach(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); //<--
        int i = 0;
        int j = str.length() - 1;
        while (i < j) { //<--
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}