// LeetCode : 424
class Solution {
    public int characterReplacement(String s, int k) {        
        return twoAndSlidingWindow(s,k);
        //return bruteForce(s,k);
    }

    // Sunday, June 28, 2026 1:15:44 PM
	// TC : O(n^2) | SC : O(1)
    // TLE 
    private int bruteForce(String s, int k) {
        int maxLen = 0;
        
        for(int start=0;start<s.length();start++){
            int[] freqArr = new int[26]; // Keep Track of Freq
            int maxFreq = 0;            
            
            for(int end=start;end<s.length();end++){
                int index = s.charAt(end)-'A'; //<--
                freqArr[index]++; //<--
                
                maxFreq = Math.max(maxFreq,freqArr[index]);
                int windowLen = end-start+1; //<--
                int changes = windowLen - maxFreq;

                if(changes<=k){
                    maxLen = Math.max(maxLen,windowLen);
                }
                // Should I use break Statement ??
            }
        }
        return maxLen;
    }


    // Sunday, June 28, 2026 1:04:39 PM
    // TC : O(n) | SC : O(n)
    private int twoAndSlidingWindow(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;  
                    
        for(int right=0;right<s.length();right++){
            
            int rightIndex = s.charAt(right)-'A';
            freq[rightIndex]++;

            maxFreq = Math.max(maxFreq,freq[rightIndex]);

            // Never use windowLen || Always use right-left+1

            while((right-left+1)-maxFreq>k){
                int leftIndex = s.charAt(left)-'A';
                freq[leftIndex]--;                
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}