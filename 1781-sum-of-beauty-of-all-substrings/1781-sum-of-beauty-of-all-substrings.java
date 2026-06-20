class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();

        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j=i;j<n;j++){                
                freq[s.charAt(j)-'a']++;
                int beauty = getMaxCount(freq) - getMinCount(freq);
                sum += beauty;        
            }
        }
        return sum;
    }

    private int getMaxCount(int[] freq){
        int maxCount = 0;
        for(int i=0;i<26;i++){
            maxCount = Math.max(maxCount, freq[i]);
        }
        return maxCount;
    }

    private int getMinCount(int[] freq){
        int minCount = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                minCount = Math.min(minCount, freq[i]);
            }
        }
        return minCount;
    }
}
// Sunday, June 14, 2026 9:13:24 PM
// TC : O(2^nnlognk) | SC : O(1n2^nlogkh)
// LeetCode : 1781