class Solution {
    public int[] sortArray(int[] nums) {
        // return defaultMethod(nums);
        // return heapSort(nums);
        //return heapSortJitender(nums);
        //return quickSortHoare(nums,0,nums.length-1);
        //return quickSortLomuto(nums,0,nums.length-1); //TLE
        return mergeSort(nums);
    }

    private int[] mergeSort(int[] nums){
        mergeSortHelper(nums,0,nums.length-1);
        return nums;
    }

    private void mergeSortHelper(int[] nums,int beg,int end){
        if(beg<end){ //<--
            int mid = beg +  (end - beg)/2;
            mergeSortHelper(nums,beg,mid);
            mergeSortHelper(nums,mid+1,end); //<--
            mergeTwoArray(nums,beg,mid,end);
        }
    }

    private void mergeTwoArray(int[] nums,int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(nums,start,mid+1);
        int[] right = Arrays.copyOfRange(nums,mid+1,end+1);

        int i=0,j=0;
        int k = start; //<--

        while(i<left.length && j < right.length){
            if(left[i]<right[j]){ //<--
                nums[k++]=left[i++]; //<--
            }else{ 
                nums[k++]=right[j++]; //<--
            }
        }
        while(i<left.length){
            nums[k++] = left[i++]; //<--
        }

        while(j<right.length){
            nums[k++] = right[j++]; //<--
        }
    }



    // TLE in All Cases
    public int[] quickSortLomuto(int[] nums,int start,int end) {
        if(start<end){            
        // int pi = LomutoPartitionScheme(nums,start,end); // TLE
        int pi = randomizedLomutoPartition(nums, start, end);  // Use random pivot //TLE
        quickSortLomuto(nums,start,pi-1); //<--
        quickSortLomuto(nums,pi+1,end);
        }
        return nums;
    }   
    public int randomizedLomutoPartition(int[] arr,int start,int end){
        Random rand = new Random();
        /**
        int randompi = start +  rand.nextInt(end-start+1);
        swap(arr,randompi,end);
        */
        int mid = start + (end - start) / 2;
        int median = medianOfThree(arr, start, mid, end);
        swap(arr, median, end);

        return LomutoPartitionScheme(arr,start,end);
    }

    private int medianOfThree(int[] arr, int a, int b, int c) {
    if ((arr[a] > arr[b]) ^ (arr[a] > arr[c])) return a;
    else if ((arr[b] < arr[a]) ^ (arr[b] < arr[c])) return b;
    else return c;
    }
    public int LomutoPartitionScheme(int[] arr,int start,int end){
        int pivot = arr[end];
        int left = start-1;
        int right = start;
        while(right<end){
            if(arr[right]<=pivot){
                left++;
                swap(arr,left,right);
            }
            right++;
        }
        swap(arr,left+1,end);
        return left+1;
    }

    // Friday, February 7, 2025 1:26:38 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(1)
    public int[] quickSortHoare(int[] nums,int start,int end) {
        if(start<end){            
        int pi = HoarePartitionScheme(nums,start,end);
        quickSortHoare(nums,start,pi);//<--
        quickSortHoare(nums,pi+1,end);
        }
        return nums;
    }    
    public int HoarePartitionScheme(int[] arr,int start,int end){
        int pivot = arr[start]; // Always First Index , Not First Value;
        int left=start-1;
        int right=end+1;
        while(true){
            do{ left++;}while(left<=right && arr[left]<pivot);
            do{right--;}while(left<=right && arr[right]>pivot);
            if(left>=right) return right;
            swap(arr,left,right);
        }
    }
    // Why right Not left ? We may incorrectly place it outside the array


    public int[] heapSortJitender(int[] nums) {
        int n = nums.length;
        // 1. Build Max Heap
        for(int i=n/2-1;i>=0;i--){
            heapifyDownIterativeJitender(nums,i,n-1);
        }
        int li = n-1;
        while(li>0){
            swap(nums,0,li);
            li--;
            heapifyDownIterativeJitender(nums,0,li);
        }
        return nums;
    }

    public void heapifyDownIterativeJitender(int[] arr, int idx, int li) {
        while(idx<=li){
            int largest = idx;
            int lc = 2*idx+1;
            int rc = 2*idx+2;
            if(lc<=li && arr[lc]>arr[largest]){
                largest=lc;
            }
            if(rc<=li && arr[rc]>arr[largest]){
                largest=rc;
            }
            if(largest!=idx){
                swap(arr,largest,idx);
                idx=largest;
            }else{
                break;
            }
        }
    }


    // Time Complexity:O(nlogn) | Space Complexity:O(1)
    public int[] heapSort(int[] nums) {
        int n = nums.length;
        // 1 Build MaxHeap
        
        // Time Complexity:O(logn) | Space Complexity:O(1)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDownIterative(nums, i, n);
        }
        
        // 2 Extract element from heap        
        // Time Complexity:O(n) | Space Complexity:O(1)
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