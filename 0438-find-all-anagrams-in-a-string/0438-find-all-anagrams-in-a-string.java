// LeetCode : 438
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //return hashMap(s,p);
        return freqArray(s,p);
    }

    public List<Integer> freqArray(String s, String p) {
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        // Don't i need to check invalid entry ?
        List<Integer> result = new ArrayList<>();
        for(char c : p.toCharArray()){
            pCount[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            sCount[s.charAt(i)-'a']++;
            if(i>=p.length()){
                sCount[s.charAt(i-p.length())-'a']--;
            }

            if(Arrays.equals(pCount, sCount)){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }

    // Wednesday, November 4, 2026 12:27:02 AM    
    // TC : O(n) | SC : O(n)
    public List<Integer> hashMap(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if(n>m) return res;        
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : p.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }   
        Map<Character,Integer> window = new HashMap<>();
        int start = 0;
        for(int end=0;end<m;end++){
            char ch = s.charAt(end);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(end-start+1>n){
                char remove = s.charAt(start);
                window.put(remove,window.get(remove)-1);
                if(window.get(remove)==0){
                    window.remove(remove);
                }
                start++;
            }
            if(end-start+1==n){
                if(map.equals(window)){
                    res.add(start);
                }
            }            
        }
        return res;
    }
}