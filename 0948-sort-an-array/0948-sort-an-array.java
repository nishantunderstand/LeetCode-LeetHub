class Solution {
    public int[] sortArray(int[] nums) {
        // return defaultMethod(nums);
        return heapSort(nums);
    }

    public int[] heapSort(int[] nums) {
        int n = nums.length;
        // 1 Build MaxHeap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDownIterative(nums, i, n);
        }
        // 2 Extract element from heap
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapifyDownIterative(nums, 0, i);
        }
        return nums;
    }

    // Max_Heap
    public void heapifyDownIterative(int[] arr, int idx, int n) {
        while (idx < n) {
        int largest = idx;
        int lc = 2 * idx + 1;
        int rc = 2 * idx + 2;
            if (lc < n && arr[lc] > arr[largest]) {
                largest = lc;
            }
            if (rc < n && arr[rc] > arr[largest]) {
                largest = rc;
            }
            if (largest != idx) {
                swap(arr, largest, idx);
                idx = largest;
            } else {
                break;
            }
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Sunday, November 17, 2024 7:55:19 PM
    // Dual Pivot Quick Sort (Java Internally Use)
    // T.C - O(nlogn) | S.C - O(1)
    public int[] defaultMethod(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}