// LeetCode : 345
class Solution {
    public String reverseVowels(String s) {
        return reverseVowelsApproach(s);
    }
    // Thursday, January 29, 2026 1:18:13 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public String reverseVowelsApproach(String s) {
        char[] arr = s.toCharArray();
        int beg = 0;
        int end = arr.length-1;        
        while(beg<end){
            while(beg<end && !isVowel(arr[beg])){
                beg++;
            }
            while(beg<end && !isVowel(arr[end])){
                end--;
            }
            // Reverse
            char temp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = temp;
            beg++;
            end--;
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
    }

    private boolean isVowelOLD(char ch){
        return ch=='a' || ch=='A'  
        || ch=='e' || ch=='E' 
        || ch== 'i' || ch== 'I'
        || ch== 'o' || ch== 'O'
        || ch== 'u' || ch== 'U';
    }
}