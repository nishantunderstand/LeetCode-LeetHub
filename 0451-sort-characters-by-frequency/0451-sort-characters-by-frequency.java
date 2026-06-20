// Sunday, June 14, 2026 7:10:17 PM
// TC : O(n) | SC : O(n)
// LeetCode : 451
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> freqMap.get(b)-freqMap.get(a)); //<--

        // Adding All the Key | Sorting Based on Freq 
        maxHeap.addAll(freqMap.keySet()); //<--

        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            int freq = freqMap.get(ch);
            while(freq-->0){ //<--
                result.append(ch);
            }
        }
        return new String(result); //<--
    }
}