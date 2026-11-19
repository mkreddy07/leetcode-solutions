class MedianFinder 
{

    //Brute Force:
    //ArrayList<Integer> list;

    // public MedianFinder() {
    //    list = new ArrayList<>();
    // }
    
    // public void addNum(int num) {
    //     list.add(num);
    // }
    
    // public double findMedian() {
    //     Collections.sort(list);


    //     if(list.size()%2!=0)
    //         return list.get(list.size()/2);
        
    //     int mid1 = list.get((list.size()/2)-1);
    //     int mid2 = list.get(list.size()/2);

    //     return (mid1+mid2)/2.0;
    // }


     PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        // Max Heap: Smaller half
        maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        // Min Heap: Larger half
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Insert the number into the appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Step 2: Balance the two heaps

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        // Even number of elements
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */