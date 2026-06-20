class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();
        
        StringBuilder prefix = new StringBuilder();

        int limit = Math.min(first.length,last.length);
        
        for(int i=0;i<limit;i++){
            if(first[i]!=last[i]){
                break;
            }
            prefix.append(first[i]);
        }
        
        return prefix.toString();
    }   
}
// Saturday, June 6, 2026 7:40:52 PM
// TC : O(nlogn+n) | SC : O(1)
// LeetCode : 14