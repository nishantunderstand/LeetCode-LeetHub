// LeetCode : 88
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // bruteForce(nums1,m,nums2,n); //<--
        priorityQueue(nums1,m,nums2,n);
    }  

    private void priorityQueue(int[] nums1,int m, int[] nums2,int n){
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for(int i=0;i<m;i++){
            minPQ.offer(nums1[i]);
        }
        for(int i=0;i<n;i++){
            minPQ.offer(nums2[i]);
        }        
        int idx=0;
        while(minPQ.size()!=0){
            nums1[idx++]=minPQ.poll();
        }  
    }

    // Add all nums2 element to  nums1, Then Sort it
    // Saturday, February 8, 2025 3:05:38 PM
    // Time Complexity:O(m+nlog(m+n)) | Space Complexity:O(1)
    public void bruteForce(int[] nums1, int m, int[] nums2, int n) {
        // Copy nums2 elements at the end of nums1
        for(int i=0;i<n;i++){//<--
            nums1[i+m]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}