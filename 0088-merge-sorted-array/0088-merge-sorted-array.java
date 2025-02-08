class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        bruteForce(nums1,m,nums2,n);
    }

    // Add all nums2 element to  nums1, Then Sort it
    // TC n, (m+n)log(m+n)
    public void bruteForce(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){//<--
            nums1[i+m]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}