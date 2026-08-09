// LeetCode : 49
// Sunday, August 9, 2026 9:43:22 PM
// TC : O(n*klogk) | SC : O(n*k)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray(); // eat
            Arrays.sort(arr);     // aet 
            String key = new String(arr);
            map.putIfAbsent(key, new ArrayList<>()); // Can we use put ? NO, Replace OLD LIST
            map.get(key).add(str);  // Adding to the List 
        }
        return new ArrayList<>(map.values());
    }
}