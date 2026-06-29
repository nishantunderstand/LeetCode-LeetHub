// LeetCode : 1358
class Solution {
    public int numberOfSubstrings(String s) {
        // return bruteForce(s);
        // return freqArrApproach(s);
        // return slidingWindow(s);        
        return slidingWindowFor(s);
    }
    // Monday, June 29, 2026 10:16:40 PM
	// TC : O(n) | SC : O(1)
    private int slidingWindowFor(String s) {
        int len = s.length();
        int left  = 0;
        int cnt = 0;
        int[] freq = new int[3];
        for(int right=0;right<len;right++){
            freq[s.charAt(right)-'a']++;
            while(freq[0]>0 && freq[1] > 0 && freq[2]>0){
                cnt += (len-right);
                freq[s.charAt(left)-'a']--;
                left++;
            }        
        }
        return cnt;
    }
    
    
    // a a a a b c
    // Monday, June 29, 2026 10:00:38 PM
	// TC : O(n) | SC : O(1)
    private int slidingWindow(String s) {
        int len = s.length();
        int i = 0;
        int j = 0;
        int[] map = new int[3];
        int cnt = 0;
        while(j<len){
            char ch = s.charAt(j); //<--
            map[ch-'a']++;

            while(map[0]>0 && map[1]>0 && map[2]>0){
                cnt += (len-j);

                map[s.charAt(i)-'a']--; 
                i++; //<--               
            }
            j++; //<--
        }    
        return cnt;
    }

    // Monday, June 29, 2026 9:35:41 PM
	// TC : O(n^2) | SC : O(1)
    // TLE
    private int freqArrApproach(String str) {
        int cnt = 0;
        int len = str.length();
        for (int start = 0; start < len; start++) {
            int[] freq = new int[3];

            for (int end = start; end < len; end++) {
                freq[str.charAt(end) - 'a']++;
                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) { //<--
                    // Approach 1
                    // cnt++; 
                    
                    // Approac 2
                    cnt += (len - end); //<--
                    break;
                }
            }
        }
        return cnt;
    }

    // Sunday, June 28, 2026 7:36:49 PM
    // TC : O(n^2) | SC : O(1)
    // TLE
    private int bruteForce(String str) {
        int cnt = 0;
        int len = str.length();
        for (int start = 0; start < len; start++) {
            Set<Character> seen = new HashSet<>();
            for (int end = start; end < len; end++) {
                seen.add(str.charAt(end));
                if (seen.size() == 3) {
                    cnt += (len - end); //<--
                    break;
                }
            }
        }
        return cnt;
    }
}