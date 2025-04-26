// Leetcode : 973

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Declaring Max Heap
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>(
                (a, b) -> Integer.compare(distance(b), distance(a)));

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
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}