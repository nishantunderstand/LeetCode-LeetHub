// LeetCode : 493
// LeetCode : 
	
class Solution {
    public int reversePairs(int[] nums) {
        //return bruteForce(nums);
        return mergeSort(nums,0,nums.length-1);
    }

    // Friday, June 26, 2026 10:13:01 PM
	// TC : O(n*logn) | SC : O(1)
    private int mergeSort(int[] nums, int low, int high){
        if(low>=high) return 0;
        
        int mid = low + (high-low)/2;
        int cnt = 0;

        cnt += mergeSort(nums,low,mid);
        cnt += mergeSort(nums,mid+1,high);
        cnt += countPair(nums,low, mid,high); //<--
        merge2Array(nums,low,mid,high);
        return cnt;
    }

    private int countPair(int[] nums, int low, int mid, int high){
        int count = 0;
        int right = mid+1;
        for(int left=low;left<=mid;left++){
            while(right<=high && (long) nums[left]> 2L * nums[right]){ //<--
                right++;
            }
            count += right -(mid+1); //<--
        }
        return count;
    }

    private void merge2Array(int[] nums,int low, int mid,int high){
        int[] leftArr = Arrays.copyOfRange(nums,low,mid+1);
        int[] rightArr = Arrays.copyOfRange(nums,mid+1,high+1);
        int i = 0;
        int j = 0;
        int k = low;
        
        while(i<leftArr.length && j < rightArr.length){
            if(leftArr[i]<rightArr[j]){
                nums[k++]=leftArr[i++];
            }else{
                nums[k++]=rightArr[j++];
            }
        }
        while(i<leftArr.length){
            nums[k++]=leftArr[i++];
        }
        while(j<rightArr.length){
            nums[k++] = rightArr[j++];
        }        
    }





    // Friday, June 26, 2026 9:35:31 PM
	// TC : O(n^2) | SC : O(1)
    private int bruteForce(int[] nums){
        int cnt = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((long) nums[i] > 2* (long) nums[j]){ //<--
                    cnt++;
                }
            }
        }
        return cnt;
    }
}