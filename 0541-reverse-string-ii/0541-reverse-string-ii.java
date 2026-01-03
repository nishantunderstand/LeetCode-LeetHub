// LeetCode : 541
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        for(int i=0;i<n;i+=2*k){  //<--
            int start = i;
            int end = Math.min(i+k-1, n-1);
            reverse(arr,start,end);
        }
        return new String(arr);
    }
    
    private void reverse(char[] arr, int start, int end){
        while(start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;            
            start++;
            end--;
        }
    }
    
    /**
    private void reverse_WRONG(String str, int start, int end){        
        while(start<end){
            char temp = str.charAt[end];
            str.charAt[end] = str.charAt[start];
            str.charAt[start] = temp;
            start++;
            end--;
        }
    }
    */
}