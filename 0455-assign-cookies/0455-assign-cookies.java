// LeetCode : 455
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //return bruteForce(g,s);
        return striver(g,s);
    }

    public int striver(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int m = s.length;
        int n = g.length;

        int l = 0; // Greed
        int r = 0; //Children
        while (l<m && r<n) {
            if (g[r] <= s[l]) {
                r++;                
            }
            l++; 
        }
        return r; 
    }


    public int bruteForce(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int left = 0; // Greed
        int right = 0; //Children
        while (left < g.length && right < s.length) {
            if (g[left] <= s[right]) {
                left++;
                right++;
            } else if (g[left] > s[right]) {
                right++;
            }
        }
        return right; // 
    }
}