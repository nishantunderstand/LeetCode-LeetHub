// 3306
class Solution {
    public long countOfSubstrings(String word, int k) {
        // return bruteForce(word,k);
        return slidingwindowTwoPointer(word, k);
    }

    // Tuesday, June 30, 2026 9:47:56 PM
	// TC : O(n) | SC : O(1)
    public long slidingwindowTwoPointer(String word, int k) {
        int len = word.length();
        // Precompute Next Constant Index
        int[] nextCons = new int[len];
        int lastConsIdx = len;
        for(int i=len-1;i>=0;i--){
            nextCons[i]=lastConsIdx;
            if(!isVowel(word.charAt(i))){
                lastConsIdx=i;
            }
        }

        Map<Character, Integer> hm = new HashMap<>();
        int constant = 0;
        long cnt = 0;
        int left = 0;

        for(int right=0;right<len;right++){
            char rightChar = word.charAt(right);

            if(isVowel(rightChar)){
                hm.put(rightChar,hm.getOrDefault(rightChar,0)+1);
            }else{
                constant++;
            }
            // Shrink Windwos as it is greater than k
            while(left < len && constant>k){
                char leftChar = word.charAt(left);
                if(isVowel(leftChar)){
                    hm.put(leftChar,hm.get(leftChar)-1);
                    if(hm.get(leftChar)==0){
                        hm.remove(leftChar);
                    }
                }else{
                    constant--;
                }
                left++;
            }

            // Count Valid Window
            while(left<len && constant==k && hm.size()==5){
                cnt += nextCons[right]-right;
                char leftChar = word.charAt(left);
                if(isVowel(leftChar)){
                    hm.put(leftChar,hm.get(leftChar)-1);
                    if(hm.get(leftChar)==0){
                        hm.remove(leftChar);
                    }
                }else{
                    constant--;
                }
                left++;
            }

        }        
        return cnt;
    }

    // TLE 
    // Tuesday, June 30, 2026 8:58:06 PM
    // TC : O(n^2) | SC : O(n)
    public long bruteForce(String word, int k) {
        int len = word.length();
        long cnt = 0;

        for (int start = 0; start < len; start++) {
            Map<Character, Integer> hm = new HashMap<>();
            int constant = 0;
            for (int end = start; end < len; end++) {
                char ch = word.charAt(end);
                if (isVowel(ch)) {
                    hm.put(ch, hm.getOrDefault(ch, 0) + 1);
                } else {
                    constant++;
                }
                if (constant == k && hm.size() == 5) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

}