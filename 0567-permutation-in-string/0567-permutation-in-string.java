// LeetCode : 567
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //return bruteForce(s1,s2);
        //return twoHashMapApproach(s1, s2);
        //return freqArray(s1, s2);
        return slidingWindow(s1, s2);
    }
    // Wednesday, November 4, 2026 12:01:24 AM    
    // TC : O(n) | SC : O(n)
    public boolean slidingWindow(String s1, String s2) {
        int n  = s1.length();
        int m = s2.length();
        if(n>m) return false;

        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int start =  0;
        Map<Character,Integer> window = new HashMap<>();
        for(int end=0;end<m;end++){
            char ch = s2.charAt(end);
            window.put(ch,window.getOrDefault(ch,0)+1);

            if(end-start+1>n){
                char remove = s2.charAt(start);
                window.put(remove,window.get(remove)-1);

                if(window.get(remove)==0){
                    window.remove(remove);
                }
                start++;
            }
            if(end-start+1==n){
                if(map.equals(window)) return true;
            }
        }
        return false;        
    }


    public boolean freqArray(String s1, String s2) {
        if(s1.length()> s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(char c : s1.toCharArray()){
            s1Count[c-'a']++;
        }

        // Sliding Window 
        for(int i=0;i<s2.length();i++){
            s2Count[s2.charAt(i)-'a']++;

            if(i>=s1.length()){
                s2Count[s2.charAt(i-s1.length())-'a']--;
            }

            if(Arrays.equals(s1Count,s2Count)) return true;
        }
        return false;
    }


    public boolean twoHashMapApproach(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i <= m - n; i++) {
            Map<Character, Integer> temp = new HashMap<>(map);
            for (int j = i; j < i + n; j++) {
                char ch = s2.charAt(j);
                if (!temp.containsKey(ch))
                    break;
                temp.put(ch, temp.get(ch) - 1);
                if (temp.get(ch) == 0)
                    temp.remove(ch);
                if (temp.isEmpty())
                    return true;
            }
        }
        return false;

    }

    private boolean bruteForce(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m)
            return false;

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        for (int i = 0; i <= m - n; i++) {

            String str = s2.substring(i, i + n);
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            if (new String(arr).equals(sortedS1))
                return true;
        }
        return false;
    }
}