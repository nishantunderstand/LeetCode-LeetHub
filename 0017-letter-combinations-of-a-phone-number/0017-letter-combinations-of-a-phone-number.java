class Solution {
    Map<Character,String> hm;
    public List<String> letterCombinations(String digits) {

        if(digits==null || digits.length()==0){
            return new ArrayList<>();
        }

        hm = new HashMap<>();        
        hm.put('0',"0");
        hm.put('1',"1");
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");

        
        return helper(digits);
        
    }

    private List<String> helper(String digits){
        // Base Case
        if(digits.length()==0){
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = digits.charAt(0);
        String ros = digits.substring(1);
        
        // Faith 
        List<String> rres = helper(ros); //<--
        
        // Self
        List<String> mres = new ArrayList<>();
        String code = hm.get(ch);

        for(char c : code.toCharArray()){
            for(String str : rres){
                mres.add(c+str);
            }
        }
        return mres;
    }
}
// Monday, June 8, 2026 8:35:45 PM
// TC : O(2^n) | SC : O(n)
// LeetCode : 17