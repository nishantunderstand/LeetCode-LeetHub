class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if(arr==null||n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int count=0;
        int max=0;
        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
            if(i==max){
                count++;
            }
        }
        return count;
    }
}