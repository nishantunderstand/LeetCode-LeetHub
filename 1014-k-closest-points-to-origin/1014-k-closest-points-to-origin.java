// Leetcode : 973

class Solution {

    public static class sortDistance implements Comparator<int[]> {  //<--
        @Override
        public int compare(int[] a,int[] b){
            return Integer.compare(distance(b),distance(a));
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        // Declaring Max Heap
        PriorityQueue<int[]> maxPQ1 = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));

        PriorityQueue<int[]> maxPQ = new PriorityQueue<>(new sortDistance()); //<--

        for (int[] point : points) {
            maxPQ.offer(point);
            if (maxPQ.size() > k)
                maxPQ.poll();
        }

        int[][] result = new int[k][2]; //<--
        for (int i = 0; i < k; i++) {
            result[i] = maxPQ.poll();
        }
        return result;
    }

    // Act as Comparator
    //private int distance WRONG
    //private int static distance WRONG
    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}