class Solution {
    public String longestPalindrome(String s) {        
        //String ans = s.substring(0,1); //<-
        String ans = "";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){ //<--
                String curr = s.substring(i,j);
                if(isPalindrome(curr) && curr.length()>ans.length()){
                    ans = curr;
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String str){
        int left=0,right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++; right--;
        }
        return true;
    }
}