import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Guarantee sorted order
        List<List<Integer>> res = new ArrayList<>();

        // Need at least 4 numbers
        if (nums == null || nums.length < 4) {
            return res;
        }

        // Fix first number
        for (int i = 0; i < nums.length - 3; i++) {

            // Skip duplicates for first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int first = nums[i];
            long newTarget = (long) target - first; //<--

            // Get all triplets from remaining array
            List<List<Integer>> triplets = threeSum(nums, i + 1, newTarget); //<--

            // Add the fixed first number to each triplet
            for (List<Integer> triplet : triplets) {
                List<Integer> quad = new ArrayList<>();
                quad.add(first);
                quad.addAll(triplet);
                res.add(quad);
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, long k) {
        List<List<Integer>> res = new ArrayList<>();

        // Fix second number
        for (int i = start; i < nums.length - 2; i++) {

            // Skip duplicates for second number
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            int first = nums[i];
            long target = k - first; //<--

            // Get all pairs from remaining array
            List<List<Integer>> pairs = twoSum(nums, i + 1, target); //<--

            // Add the fixed number to each pair
            for (List<Integer> pair : pairs) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(first);
                triplet.addAll(pair);
                res.add(triplet);
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, long k) {
        int low = start;
        int high = nums.length - 1;

        List<List<Integer>> res = new ArrayList<>();

        while (low < high) {
            long currentSum = (long) nums[low] + nums[high];

            if (currentSum == k) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[low]);
                pair.add(nums[high]);
                res.add(pair);

                low++;
                high--;

                // Skip duplicates
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }

                while (low < high && nums[high] == nums[high + 1]) {
                    high--;
                }

            } else if (currentSum < k) {
                low++;
            } else {
                high--;
            }
        }

        return res;
    }
}