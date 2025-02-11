// LeetCode 17

class Solution {
    /**
    // If you plan to declare here that's how you will declare
    private static final HashMap<Character,String> hm = new HashMap<>();
    static{
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
        
    }

    */

    public List<String> letterCombinations(String digits) {
        return hashingBackting(digits);
    }

    // Tuesday, February 11, 2025 4:35:02 PM
    // Time Complexity:O(4^n) | Space Complexity:O(n)
    public List<String> hashingBackting(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.isEmpty()) return res;

        HashMap<Character,String> hm = new HashMap<>();
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

        backtracking(res,new StringBuilder(),digits,0,hm);
        return res;
    }
    
    public void backtracking(List<String> res,StringBuilder curr,String digits,int index,HashMap<Character,String> hm){
        if(index == digits.length()){
            res.add(curr.toString());
            return;
        }
        char currDigit = digits.charAt(index);
        String letters = hm.get(currDigit);
        if(letters==null) return;

        for(char ch : letters.toCharArray()){
            curr.append(ch);
            backtracking(res,curr,digits,index+1,hm);
            curr.deleteCharAt(curr.length()-1); //<--
        }                
    }
}