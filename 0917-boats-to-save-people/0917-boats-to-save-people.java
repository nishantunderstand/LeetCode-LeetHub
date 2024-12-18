/**
    LeetCode 881 , Children and Rides Question 
    [3,2,2,1], limit = 3
*/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // return twoPointerEqualVersion(people, limit);
        // return twoPointer(people,limit);
        return twoPointerMod(people, limit);
        // return twoPointerPepCoding(people, limit);

    }

    public int twoPointerPepCoding(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boat = 0;
        while (left <= right) {
            int target = people[left] + people[right];
            if (target <= limit) {
                left++;
                right--;
                boat++;
            } else {
                right--;
                boat++;
            }
        }
        return boat;
    }

    public int twoPointerEqualVersion(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int target = 0;
        int boat = 0;
        while (left < right) {
            target = people[left] + people[right];
            if (target <= limit) {
                left++;
                right--;
                boat++;
            } else {
                right--;
                boat++;
            }
        }

        if (left == right) {
            boat++;
        }
        return boat;

    }


    public int twoPointer(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int target = 0;
        int boat = 0;
        while (left <= right) {
            target = people[left] + people[right];
            if (target <= limit) {
                left++;
                right--;
                boat++;
            } else {
                right--;
                boat++;
            }
        }
        return boat;
    }

    // TC - O(nlogn)+O(n) | SC-O(1) || Correct But I don't like Code Structure
    public int twoPointerMod(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int target = 0;
        int boat = 0;
        while (left <= right) {
            target = people[left] + people[right];
            if (target <= limit) {
                left++;
            }
            right--;
            boat++;
        }
        return boat;
    }

}