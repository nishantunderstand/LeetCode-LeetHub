// LeetCode 66
class Solution {
    public int[] plusOne(int[] digits) {
        //return arrWithArrayListCarryReverse(digits);
        //return arrWithArray(digits);
        return arrWithArrayListCarryReverseMOD(digits);
    }



    public int[] arrWithArrayListCarryReverseMOD(int[] digits) {
        int carry = 1;
        int n = digits.length;        
        List<Integer> res = new ArrayList<>(n);
        // Initialize the ArrayList with placeholder values (e.g., 0)
        for (int i = 0; i < n; i++) {
            res.add(0);
        }        
        for (int i = n - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            res.set(i, sum % 10); // Using set() to replace value at index i 
            carry = sum / 10;
        }
    
        if (carry != 0) {
            res.add(0, carry);
        }        
        int[] resArr = new int[res.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }
        
        return resArr;
    }


    // Tuesday, April 22, 2025 10:36:48 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int[] arrWithArrayListCarryReverse(int[] digits) {
        int carry = 1;
        int n = digits.length;
        List<Integer> res = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            res.add(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            res.add(carry);
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(res.size() - 1 - i); // Write in Reverse Manner
        }
        return resArr;
    }
    



    // Walkccc
    public int[] arrWithArray(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

    
}