class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // return bruteForceApproach(nums);
        // return bruteForceApproachMod(nums);
        return optimalApproach(nums);
    }

    public List<List<Integer>> optimalApproach(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n<3){
            return res;
        }
        HashSet<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> hashset = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third = -(nums[i]+nums[j]);
                if(hashset.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(nums[j]);
            }
        }
        res.addAll(st);
        return res;
    }

    public List<List<Integer>> bruteForceApproachMod(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 3)
            return res;
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]); // Directly create the list
                        Collections.sort(triplet); // Sort to ensure consistent order
                        set.add(triplet); // Add to set
                    }
                }
            }
        }
        res.addAll(set);
        return res;
    }

    // T.C - O(n^3) | S.C - O(n)
    public List<List<Integer>> bruteForceApproach(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 3)
            return res;
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        set.add(triplet);
                    }
                }
            }
        }
        res.addAll(set);
        return res;
    }
}