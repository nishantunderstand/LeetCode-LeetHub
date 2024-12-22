class MedianFinder {
    PriorityQueue<Integer> minPQ ;
    PriorityQueue<Integer> maxPQ ;

    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxPQ.offer(num);
        if(maxPQ.size()>minPQ.size()){
            minPQ.add(maxPQ.poll());
        }
        if(maxPQ.size()<minPQ.size()){
            maxPQ.add(minPQ.poll());
        }
    }
    
    public double findMedian() {
        if(maxPQ.size()==minPQ.size()){
            return (maxPQ.peek() + minPQ.peek())/2.0;
        }else{
            return maxPQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */